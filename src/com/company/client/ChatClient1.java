package com.company.client;

import java.io.*;
//import java.net.Socket;
import java.util.Scanner;

public class ChatClient1 {

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        Client client= new Client();
        client.start();

        client.sendMessage("Hello from the Client...");

        String clientInput="";
        System.out.println("CHAT HERE (Enter 0 to EXIT)");

        while(!clientInput.equals("0")) {
            System.out.print("Type a message to Server: ");
            clientInput = sc.nextLine();
            if (clientInput.equals("0")){
                break;
            }
            client.sendMessage(clientInput);
        }
        client.sendMessage("Bye!");

        System.out.println("Client finished the execution...");
    }
}
