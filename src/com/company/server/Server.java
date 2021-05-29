package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server is running...");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("Server socket created...");

        while (true){
            //server is running forever...

            Socket client = serverSocket.accept(); //wait until a client connects
            System.out.println("Server accepted a client");

//            Thread.sleep(30000);//wait 20s before executing the rest of the code

            //Get data from client
            InputStream inputStream= client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //send
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //to read data only once
//        String data = bufferedReader.readLine();
//        System.out.println("Data received from Client: "+data);

            // to continuously read data from client
            String inputData;
            while((inputData = bufferedReader.readLine()) != null){

                System.out.println("Client says:  "+inputData);

                //send data to client
                //You can also use a scanner class to capture user input
                switch (inputData){
                    case "Hello from the Client.":
                        outputStream.writeBytes("Hello from the server...\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine, and you?\n");
                        break;
                    case "I'm fine.":
                        outputStream.writeBytes("Great!\n");
                        break;
                    case "Thank you.":
                        outputStream.writeBytes("You're welcome\n");
                        break;
                    case "Bye!":
                        outputStream.writeBytes("Bye!!\n");
                        break;
                    default:
                        outputStream.writeBytes("Sorry, I didn't get that.\n");
                }

                if (inputData.equals("Bye!")) {
                    break;
                }
            }

            client.close();
        }
    }
}
