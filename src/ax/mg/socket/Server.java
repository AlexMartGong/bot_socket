package ax.mg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server ready and esperado la connection");
        Socket socketClient = serverSocket.accept();

        PrintWriter exit = new PrintWriter(socketClient.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        String inputLine;

        while ((inputLine = entrada.readLine()) != null) {

            if (inputLine.equalsIgnoreCase("Dame una hora")) {

                exit.println(new Date().toString());

            } else if (inputLine.equalsIgnoreCase("Dime un Artists")) {

                List<String> Artists = Arrays.asList("Luis Miguel Luis Miguel", "Juan Gabriel", "Bereiz");
                exit.println(Artists.get(new Random().nextInt(Artists.size())));

            } else if (inputLine.equalsIgnoreCase("Dame un number random")) {

                exit.println(new Random().nextInt());

            } else if (inputLine.equalsIgnoreCase("Salir")) {

                exit.println("Exit");
                break;

            } else {

                exit.println("No entendi el mensaje");

            }

        }

        entrada.close();
        exit.close();
        socketClient.close();
        serverSocket.close();

    }
}
