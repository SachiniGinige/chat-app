package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;

    public ClientHandler(Socket socket){
        this.client=socket;
    }

    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);

        try {
            Thread.sleep(5000); //wait 5s before executing the rest of the code

            //Get data from client
            InputStream inputStream= client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //send
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //to read data only once
//        String data = bufferedReader.readLine();
//        System.out.println("Data received from Client: "+data);

            // to continuously read data from client
            String inputData="";
            String serverInput;

            outputStream.writeBytes("Hello from the Server...\n");

            inputData = bufferedReader.readLine();
            while( !inputData.equals(null)){

                inputData = bufferedReader.readLine();
                System.out.println("Client says:  "+inputData);

                if (inputData.equals("Bye!")) {
                    outputStream.writeBytes("Byeee...\n");
                    break;
                }



                //send data to client
                System.out.print("Server says: ");
                serverInput=sc.nextLine();
                outputStream.writeBytes(serverInput+"\n");


                /*
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
                */


            }

            this.client.close();
        }
        catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
