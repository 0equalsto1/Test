package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleFTPServer {

    private static final int CONTROL_PORT = 21;
    private static final int DATA_PORT = 2021; // Example data port

    public static void main(String[] args) {
        SimpleFTPServer server = new SimpleFTPServer();
        server.start();
    }

    public void start() {
        try {

            try (ServerSocket serverSocket = new ServerSocket(CONTROL_PORT);
                 ServerSocket dataServerSocket = new ServerSocket(DATA_PORT)) {
                System.out.println("FTP Server started on port " + CONTROL_PORT);

                while (true) {
                    Socket commandSocket = serverSocket.accept();
                    new ClientHandler(commandSocket, dataServerSocket).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
