package socket.server;

import socket.util.Constants;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

class ClientHandler extends Thread {
    private static final String INVALID_USER_MSSG = "101 invalid user";
    private static final String INVALID_PASS_MSSG = "102 invalid password";
    private static final String VALID_USERNAME = "user";
    private static final String VALID_PASSWORD = "pass";
    private final Socket commandSocket;
    private final ServerSocket dataServerSocket;
    private PrintWriter commandWriter;
    private boolean isAuthenticated = false;
    private String currentUser;


    public ClientHandler(Socket commandSocket, ServerSocket dataServerSocket) {
        this.commandSocket = commandSocket;
        this.dataServerSocket = dataServerSocket;

    }

    @Override
    public void run() {
        try {
            BufferedReader commandReader = new BufferedReader(new InputStreamReader(commandSocket.getInputStream()));
            commandWriter = new PrintWriter(commandSocket.getOutputStream(), true);
            commandWriter.println("220 Welcome to Simple FTP Server");

            String command;
            while ((command = commandReader.readLine()) != null) {
                handleCommand(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void handleCommand(String command) throws IOException {
        String[] commandData = command.split(" ");
        String cmd = commandData[0];

        switch (cmd) {
            case Constants.USER_COMMAND -> handleUserCommand(commandData);
            case Constants.PASS_COMMAND -> handlePassCommand(commandData);
            case Constants.PASV_COMMAND -> {
                if (isAuthenticated) handlePasvCommand();
                else commandWriter.println(Constants.NOT_LOGGED_IN);
            }
            case Constants.LIST_COMMAND -> {
                if (isAuthenticated) handleListCommand(commandData[1]);
                else commandWriter.println(Constants.NOT_LOGGED_IN);
            }
            case Constants.RETR_COMMAND -> {
                if (isAuthenticated && commandData.length > 1) handleRetrCommand(commandData[1]);
                else commandWriter.println(Constants.SYNTAX_ERROR_IN_PARAMETERS_OR_ARGUMENTS);
            }
            case Constants.STOR_COMMAND -> {
                if (isAuthenticated && commandData.length > 1) handleStorCommand(commandData[1]);
                else commandWriter.println(Constants.SYNTAX_ERROR_IN_PARAMETERS_OR_ARGUMENTS);
            }
            case Constants.QUIT_COMMAND -> commandWriter.println(Constants.GOODBYE);
            default -> commandWriter.println(Constants.COMMAND_NOT_IMPLEMENTED);
        }
    }

    private void handleUserCommand(String[] commandData) {
        if (commandData.length > 1 && VALID_USERNAME.equals(commandData[1])) {
            currentUser = commandData[1];
            commandWriter.println(Constants.USERNAME_OKAY_NEED_PASSWORD);
        } else {
            commandWriter.println(INVALID_USER_MSSG);
        }
    }

    private void handlePassCommand(String[] commandData) {
        if (commandData.length > 1) {
            String password = commandData[1];
            if (VALID_USERNAME.equals(currentUser) && VALID_PASSWORD.equals(password)) {
                isAuthenticated = true;
                commandWriter.println(Constants.USER_LOGGED_IN_PROCEED);
            } else {
                commandWriter.println(INVALID_PASS_MSSG);
            }
        } else {
            commandWriter.println(Constants.SYNTAX_ERROR_IN_PARAMETERS_OR_ARGUMENTS);
        }
    }

    private void handlePasvCommand() {
        int port = dataServerSocket.getLocalPort();
        commandWriter.println("Data-Port" + Constants.COMMAND_SEPARATOR + port);
    }

    private void handleListCommand(String dirPath) throws IOException {
        if (new File(dirPath).exists()) {
            commandWriter.println("Opening data connection for file transfer.");

            try (Socket dataSocket = dataServerSocket.accept();
                 PrintWriter dataWriter = new PrintWriter(dataSocket.getOutputStream(), true)) {

                File currentDir = new File(dirPath);
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    dataWriter.println(file.getName());
                }
            }
            commandWriter.println("226 handleListCommand complete.");
        } else
            commandWriter.println(Constants.FAILED + Constants.COMMAND_SEPARATOR + dirPath + " path not exist.");
    }

    private void handleRetrCommand(String filename) throws IOException {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            commandWriter.println("200 Opening data connection for file transfer.");

            try (Socket dataSocket = dataServerSocket.accept();
                 BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                 BufferedOutputStream bos = new BufferedOutputStream(dataSocket.getOutputStream())) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }

            commandWriter.println("handleRetrCommand complete.");
        } else {
            commandWriter.println("File not found.");
        }
    }

    private void handleStorCommand(String filename) throws IOException {
        commandWriter.println("200 Opening data connection for file transfer.");

        try (Socket dataSocket = dataServerSocket.accept();
             BufferedInputStream bis = new BufferedInputStream(dataSocket.getInputStream());
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(Constants.rootDir + filename))) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }

        commandWriter.println("handleStorCommand complete.");
    }

    private void closeResources() {
        try {
            if (commandSocket != null) commandSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}