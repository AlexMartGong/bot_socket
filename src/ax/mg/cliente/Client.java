package ax.mg.cliente;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        Socket socket = new Socket(serverAddress, 5000);

        PrintWriter exit = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String userInput;

        while (true) {
            userInput = JOptionPane.showInputDialog(null, "Message");
            if (userInput == null || userInput.equalsIgnoreCase("Salir")){
                break;
            }
            exit.println(userInput);
            System.out.println("Respuesta del Server: " + entrada.readLine());
        }
        entrada.close();
        exit.close();
        socket.close();
    }
}
