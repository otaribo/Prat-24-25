package Java.my_things.networkThings;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SimpleClient2 {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 12345;
    public static void main(String[] args) {
        

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
             BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             BufferedReader consoleInput = new BufferedReader(
                new InputStreamReader(System.in))) {

            System.out.print("Enter message: ");
            String message = consoleInput.readLine();
            writer.println(message);

            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}