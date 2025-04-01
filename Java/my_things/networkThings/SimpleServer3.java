package Java.my_things.networkThings;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class SimpleServer3 {
    public static final int PORT = 12345;
    
    public static void main(String[] args) {
        
        try(ServerSocket serverSocket = new ServerSocket(PORT);){
            while(true){
                Socket clientSocket = serverSocket.accept();
                new Thread (() -> sendMessage(clientSocket)).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void sendMessage(Socket CS){
        try{
            BufferedReader getData = new BufferedReader(new InputStreamReader(CS.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter sendData = new PrintWriter(new OutputStreamWriter(CS.getOutputStream(), StandardCharsets.UTF_8), true);

            String clientMessage = getData.readLine();
            System.out.println("Received from client: " + clientMessage);

            sendData.println("Missatge rebut.");
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                CS.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
