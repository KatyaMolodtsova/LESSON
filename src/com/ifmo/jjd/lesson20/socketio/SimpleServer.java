package com.ifmo.jjd.lesson20.socketio;

import com.ifmo.jjd.lesson8.SomeUtils;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private Connection connection;

    public void start() throws IOException, ClassNotFoundException {
        // ServerSocket ждет входящих подключений на указанном порту
        try (ServerSocket serverSocket = new ServerSocket(8090)){ //клиент постучался на сервер
            System.out.println("Server started");
            while (true){
                Socket socket = serverSocket.accept(); // принятие клиента, установка соединения
                connection = new Connection(socket);
                System.out.println(connection.readMessage()); // читаем сообщение по конкретному соединению
                connection.sendMessage(SimpleMessage.getMessage("server", "получено")); // отправляем сообщение
            }
        }
    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException ioException) {
            ioException.printStackTrace(); // консольный вывод
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
} // ip 127.0.0.1 : 8090
