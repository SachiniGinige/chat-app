package com.company;

import java.io.*;
//import java.net.Socket;

public class ChatClient1 {

    public static void main(String[] args) throws IOException {

        Client client= new Client();
        client.start();

        client.sendMessage("Hello from the Client.");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine.");
        client.sendMessage("Thank you.");
        client.sendMessage("Bye!");

        System.out.println("Client finished the execution...");





    }
}
