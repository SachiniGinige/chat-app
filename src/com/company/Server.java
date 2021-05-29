package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server is running...");

        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created...");

        Socket client = serverSocket.accept(); //wait until a client connects
        System.out.println("Server accepted a client");

        //Send some data to client
        DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
        outputStream.writeBytes("Hello from the server...\n");

        client.close();

        //InputStream and OutputStream
    }
}
