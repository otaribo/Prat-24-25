package Java.my_things.networkThings;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimpleClient3 {
    public static Scanner scan = new Scanner(System.in);
    public static String HOST;
    public static final int PORT = 12345;
    
    public static void main(String[] args) {
        System.out.print("Introdueix la direccio IP: ");
        HOST = scan.nextLine();
        while(true) {
            try (Socket socket = new Socket(HOST, PORT);
                 PrintWriter writer = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                 BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
                
                System.out.print("Enter message: ");
                String message = scan.nextLine(); // Use the same Scanner for all inputs
                writer.println(message);
                
                String response = in.readLine();
                System.out.println("Server response: " + response);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}