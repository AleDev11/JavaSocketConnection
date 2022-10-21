package es.campusnet.m09.uf1.socket.basico.client;

import es.campusnet.m09.uf1.socket.basico.configuration.Settings;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ConnectionClient {
    private Socket socketClient = null;
    private DataInputStream dataInputStream = null;
    private DataOutputStream dataOutputStream = null;

    public void ConnectetServer() {
        try {
            // Creamos la conexión con el servidor
            socketClient = new Socket(Settings.HOST, Settings.PORT);
            System.out.println("[CLIENT] Connected to server");

            // Configuramos los flujos de entrada y salida
            dataInputStream = new DataInputStream(socketClient.getInputStream());
            dataOutputStream = new DataOutputStream(socketClient.getOutputStream());

            // Esperando la respuesta del servidor
            String msgServer = dataInputStream.readUTF();
            System.out.println("[SERVER] Message: " + msgServer);

            dataOutputStream.writeUTF("[Client] Hello server");

            msgServer = dataInputStream.readUTF();
            System.out.println("[SERVER] Mensaje recived" + msgServer);

            // Cerramos la conexión
            socketClient.close();
            System.out.println("[CLIENT] Connection closed");

        } catch (Exception e) {
            System.out.println("[CLIENT] Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
