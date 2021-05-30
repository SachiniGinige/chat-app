package com.company.client;

import java.io.*;
import java.net.Socket;

public class Client {
    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    //Can even place this start method code in a constructor so that you don't need to start it manually
    public void start() throws IOException {
        System.out.println("Client is running...");
        Socket socket = new Socket("localhost", 6000);

        this.outputStream = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void sendMessage(String message) throws  IOException{
        System.out.println("Client says: "+message);
        this.outputStream.writeBytes(message+"\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("Server says: "+dataFromServer);
    }
}
