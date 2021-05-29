package com.company;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Client is running...");
        Socket socket = new Socket("localhost", 6000);

        //Get the data from the server
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String receivedData = bufferedReader.readLine();

        System.out.println("Data received from server "+ receivedData);
        System.out.println("Client finished the execution...");
        //InputStream and OutputStream
    }
}
