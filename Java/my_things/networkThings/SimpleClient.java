package Java.my_things.networkThings;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleClient {

    // Configuración (modifica estos valores)
    private static final String DESTINATION_IP = "192.168.2.35"; // IP del dispositivo destino
    private static final int DESTINATION_PORT = 12345;            // Puerto de destino
    private static String MESSAGE_TO_SEND = "Hola dispositivo!"; // Mensaje a enviar
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try (Socket socket = new Socket(DESTINATION_IP, DESTINATION_PORT)) {
            // Configurar flujos de salida
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            System.out.print("Introdueix un missatge: ");
            MESSAGE_TO_SEND = scan.nextLine();
            
            // Enviar el mensaje
            writer.println(MESSAGE_TO_SEND);
            System.out.println("Mensaje enviado a " + DESTINATION_IP + ":" + DESTINATION_PORT);

        } catch (UnknownHostException ex) {
            System.err.println("IP no válida: " + DESTINATION_IP);
        } catch (IOException ex) {
            System.err.println("Error de conexión: " + ex.getMessage());
        }
    }
}