package org.aut.ce.server;


import org.aut.ce.common.Score;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
	try {
        ServerSocket serverSocket = new ServerSocket(2000);
        Socket client = serverSocket.accept();
        ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
        Score clientMessage = (Score) inputStream.readObject();
        System.out.println(clientMessage.toString());
    }catch (IOException | ClassNotFoundException exception){
        exception.printStackTrace();
    }


    }
}
