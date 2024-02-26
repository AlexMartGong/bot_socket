package ax.mg.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server ready and esperado la connection");
        Socket socketClient = serverSocket.accept();

        PrintWriter exit = new PrintWriter(socketClient.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        String inputLine;

    }
}
