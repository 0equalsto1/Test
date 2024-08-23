package socket.client;

import socket.util.Constants;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FTPClient {
    private static final String SERVER_ADDRESS = "localhost"; // FTP server address
    private static final int SERVER_PORT = 21; // FTP server port
    private static final Scanner scanner = new Scanner(System.in);

    private Socket commandSocket;
    private BufferedReader commandReader;
    private PrintWriter commandWriter;
    private Pattern p = Pattern.compile(" ");

    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        client.start();
    }

    public void start() {
        try {
            connectToServer();
            authenticate();
            interactWithServer();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    private void connectToServer() throws IOException {
        commandSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        commandReader = new BufferedReader(new InputStreamReader(commandSocket.getInputStream()));
        commandWriter = new PrintWriter(commandSocket.getOutputStream(), true);
        System.out.println(commandReader.readLine()); // Print server greeting
    }

    private void authenticate() throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        sendCommand(Constants.USER_COMMAND + Constants.COMMAND_SEPARATOR + username);
        System.out.println(commandReader.readLine());

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        sendCommand(Constants.PASS_COMMAND + Constants.COMMAND_SEPARATOR + password);
        System.out.println(commandReader.readLine());
    }

    private void interactWithServer() throws IOException {
        String reqData;
        while (true) {
            System.out.print("FTP> ");
            reqData = scanner.nextLine();
            if (reqData.equals(Constants.QUIT_COMMAND)) {
                sendCommand(Constants.QUIT_COMMAND);
                System.out.println(commandReader.readLine());
                break;
            }
            handleCommand(reqData);
        }
    }

    private void handleCommand(String reqData) throws IOException {
        String[] commandsData = p.split(reqData);
        String command = commandsData[0];
        switch (command) {
            case Constants.LIST_COMMAND -> listFiles(commandsData[1]);
            case Constants.RETR_COMMAND -> retrieveFile(commandsData[1]);
            case Constants.STOR_COMMAND -> {
                String fileName = commandsData[1];
                String filePath = commandsData[2];
                uploadFile(fileName, filePath);
            }
            default -> {
                sendCommand(reqData);
                System.out.println(commandReader.readLine());
            }
        }
    }

    private void listFiles(String dirPath) throws IOException {
        int port = enterPassiveMode();
        sendCommand(Constants.LIST_COMMAND + Constants.COMMAND_SEPARATOR + dirPath);
        String response = commandReader.readLine();
        System.out.println(response);
        if (response.startsWith(Constants.SUCCESS)) {
            try (Socket dataSocket = new Socket(SERVER_ADDRESS, port);
                 BufferedReader dataReader = new BufferedReader(new InputStreamReader(dataSocket.getInputStream()))) {
                String line;
                while ((line = dataReader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        System.out.println(commandReader.readLine()); // Final status message from server
    }

    private void uploadFile(String filename, String filePath) throws IOException {
        int port = enterPassiveMode();
        sendCommand(Constants.STOR_COMMAND + Constants.COMMAND_SEPARATOR + filename);
        String response = commandReader.readLine();
        System.out.println(response);

        if (response.startsWith(Constants.SUCCESS)) {
            try (Socket dataSocket = new Socket(SERVER_ADDRESS, port);
                 FileInputStream fis = new FileInputStream(filePath);
                 BufferedOutputStream bos = new BufferedOutputStream(dataSocket.getOutputStream())) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println(commandReader.readLine()); // Transfer complete message
        }
    }

    private void retrieveFile(String filename) throws IOException {
        int port = enterPassiveMode();
        sendCommand(Constants.RETR_COMMAND + Constants.COMMAND_SEPARATOR + filename);
        String response = commandReader.readLine();
        System.out.println(response);

        if (response.startsWith("150")) {
            try (Socket dataSocket = new Socket(SERVER_ADDRESS, port);
                 BufferedInputStream bis = new BufferedInputStream(dataSocket.getInputStream());
                 FileOutputStream fos = new FileOutputStream(filename)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println(commandReader.readLine()); // Transfer complete message
        }
    }

    private int enterPassiveMode() throws IOException {
        sendCommand(Constants.PASV_COMMAND);
        String pasvResponse = commandReader.readLine();
        System.out.println(pasvResponse);

        return Integer.parseInt(p.split(pasvResponse)[1]);
    }

    private void sendCommand(String command) {
        commandWriter.println(command);
    }

    private void closeResources() {
        try {
            if (commandSocket != null) commandSocket.close();
            if (scanner != null) scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
