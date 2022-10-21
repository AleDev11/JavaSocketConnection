package es.campusnet.m09.uf1.socket.basico.client;

public class MainClient {
    public static void main(String[] args) {
        ConnectionClient connectionClient = new ConnectionClient();
        connectionClient.ConnectetServer();
    }
}
