package com.company.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ChatClientForm extends JFrame{
    private JButton btnSend;
    private JTextField txtClientInput;
    private JPanel FormPanel;
    private JButton EndButton;
    private JLabel lbl1;
    private JTextArea textAreaView;

    public ChatClientForm (String title) {
        this.setContentPane(FormPanel);
        this.setTitle(title);

        Client client= new Client();
        try {
            client.start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            client.sendMessage("Hello from the Client 3.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        textAreaView.append("\nClient: "+"Hello from the Client 3.");

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String msg=txtClientInput.getText().toString();
                textAreaView.append("\n\nClient: "+msg);
                txtClientInput.setText("");
                try {
                    client.sendMessage(msg);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        EndButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.sendMessage("Bye!");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                textAreaView.append("\n\nClient: "+"Bye!");
                System.out.println("Client finished the execution...");
            }
        });
    }

    public static void main(String[] args){
        ChatClientForm chatClientForm =new ChatClientForm("Chat Client 3");
        chatClientForm.setSize(500,700);
        chatClientForm.setDefaultCloseOperation(ChatClientForm.EXIT_ON_CLOSE);
        chatClientForm.setVisible(true);
    }
}
