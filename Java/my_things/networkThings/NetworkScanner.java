package Java.my_things.networkThings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class NetworkScanner {

    public static void main(String[] args) throws Exception {
        List<String> activeIPs = scanNetwork();
        System.out.println("Dispositivos activos:");
        activeIPs.forEach(System.out::println);
    }

    public static List<String> scanNetwork() throws Exception {
        List<String> activeIPs = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(20);

        // Obtener IP local y calcular rango de red
        String localIP = InetAddress.getLocalHost().getHostAddress();
        String subnet = localIP.substring(0, localIP.lastIndexOf('.') + 1);

        // Escanear direcciones IP en el rango 1-254
        for (int i = 1; i < 255; i++) {
            String ip = subnet + i;
            executor.execute(() -> {
                try {
                    if (isReachable(ip)) {
                        activeIPs.add(ip + " - " + getMacAddress(ip));
                    }
                } catch (Exception e) {
                    // Manejar excepciones
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        // Agregar dispositivos de la caché ARP
        activeIPs.addAll(checkARPCache());
        
        return activeIPs;
    }

    private static boolean isReachable(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.isReachable(500);
        } catch (IOException e) {
            return false;
        }
    }

    private static List<String> checkARPCache() {
        List<String> arpEntries = new ArrayList<>();
        try {
            Process process;
            if (System.getProperty("os.name").startsWith("Windows")) {
                process = Runtime.getRuntime().exec("arp -a");
            } else {
                process = Runtime.getRuntime().exec("arp -n");
            }
            
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("dinámico") || line.contains("ether")) {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length >= 2) {
                        arpEntries.add(parts[0] + " - " + parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arpEntries;
    }

    private static String getMacAddress(String ip) {
        // Implementación para obtener MAC (requiere permisos elevados)
        return "MAC no disponible";
    }
}
