package Java.my_things.networkThings;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SimpleServer2 {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8), true)) {

            String clientMessage = in.readLine();
            System.out.println("Received from client: " + clientMessage);

            String response = generateResponse(clientMessage);
            writer.println(response);
            System.out.println("Sent response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateResponse(String clientMessage) {
        if (clientMessage == null) return "No message received";
        
        return switch (clientMessage.trim().toLowerCase()) {
            case "hello" -> "Hi there! How can I help you?";
            case "time" -> "Current time: " + new java.util.Date();
            case "status" -> "Server is operational";
            case "secret" -> "The answer is 42";
            default -> "Unknown command. Try: hello, time, status, secret";
        };
    }
}