package com.gmg.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ReverseServer {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            new ReverseClientHandler(serverSocket.accept()).run();
        }
    }

    private static class ReverseClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public ReverseClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputText;
                while ((inputText = in.readLine()) != null) {
                    // Assuming a stop case to stop the connection.
                    if (".".equals(inputText)) {
                        out.println("good bye");
                        break;
                    }
                    out.println(reverseWords(inputText));
                }
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Connection with client closed");
            }
        }

        private String reverseWords(String text) {
            String[] words = text.split(" ");
            StringBuilder result = new StringBuilder();
            Arrays.asList(words).replaceAll(s -> new StringBuilder(s).reverse().toString());
            for (String word : words) {
                result.append(word).append(" ");
            }
            return result.toString().trim();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        ReverseServer server=new ReverseServer();
        server.start(9999);
    }
}
