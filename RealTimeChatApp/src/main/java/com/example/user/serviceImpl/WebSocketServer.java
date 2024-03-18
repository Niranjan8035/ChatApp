package com.example.user.serviceImpl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServer {
	private static Logger logger = LogManager.getLogger(WebSocketServer.class);

	private int port;
	private final List<WebSocketClientHandler> clients = new ArrayList<>();

//	public WebSocketServer(int port) {
//		this.port = port;
//	}

	public void start() {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			logger.info("WebSocket server is listening on port " + port);
			while (true) {
				Socket clientSocket = serverSocket.accept();
				logger.info("New client connected: " + clientSocket.getInetAddress().getHostAddress());
				WebSocketClientHandler clientHandler = new WebSocketClientHandler(clientSocket, this);
				clients.add(clientHandler);
				new Thread(clientHandler).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void broadcastMessage(String message) {
		for (WebSocketClientHandler client : clients) {
			client.sendMessage(message);
		}

//	public static void main(String[] args) {
//		int port = 8082; // Change this to your desired port number
//		WebSocketServer server = new WebSocketServer(port);
//		server.start();
//	}

	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
