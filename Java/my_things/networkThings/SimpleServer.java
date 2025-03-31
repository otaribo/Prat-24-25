package Java.my_things.networkThings;

import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Servidor esperando conexiones...");
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()))) {
                     
                    String receivedMessage = reader.readLine();
                    System.out.println("Mensaje recibido: " + receivedMessage);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}