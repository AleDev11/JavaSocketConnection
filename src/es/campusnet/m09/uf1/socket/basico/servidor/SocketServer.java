package es.campusnet.m09.uf1.socket.basico.servidor;

import es.campusnet.m09.uf1.socket.basico.configuration.Settings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer  {
    ServerSocket serverSocket = null;
    Socket socket = null;

    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;

    public void connection() {
        try {
            // clreamos la escucha del servidor
            serverSocket = new ServerSocket(Settings.PORT);

            while (true) {
                System.out.println("[SERVER] Waiting for client...");
                // Esperando la conexión de los clientes
                socket = serverSocket.accept();
                System.out.println("[SERVER] Client connected");

                // Configuramos los flujos de entrada y salida
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                dataOutputStream.writeUTF("[SERVER] Hola como estas!");

                // Nos quedamos a la espera de un mensaje del cliente
                String msgClient = dataInputStream.readUTF();
                System.out.println("[CLIENT] Message send: " + msgClient);

                // Enviamos un mensaje al cliente
                dataOutputStream.writeUTF("[Server] Message received");

                // Cerramos la conexión
                socket.close();
                System.out.println("[SERVER] Server closed");
            }

        } catch (Exception e) {
            System.out.println("[SERVER] Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
