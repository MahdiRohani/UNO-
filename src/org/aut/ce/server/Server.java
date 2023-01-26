package org.aut.ce.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
	try {
        ServerSocket serverSocket = new ServerSocket(6000);
        Socket client = serverSocket.accept();
        System.out.println(client.getPort());
    }catch (IOException exception){
        exception.printStackTrace();
    }




    }
}
