package com.example.user.serviceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebSocketClientHandler implements Runnable {

	private final Socket clientSocket;
	private final WebSocketServer server;
	private PrintWriter out;

	public WebSocketClientHandler(Socket socket, WebSocketServer server) {
		this.clientSocket = socket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(clientSocket.getInputStream());
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			while (true) {
				String message = in.nextLine();
				System.out.println("Received message from client: " + message);
				server.broadcastMessage(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		out.println(message);
	}
}