package com.ifmo.jjd.lesson20.socketio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        String name = scanner.nextLine();
        String message;
        while (true) {
            System.out.println("Введите сообщение");
            message = scanner.nextLine();
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        // отсутствие многопоточности на сервере
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("от сервера: " + fromServer);
        }
    }

    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 8090).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // если нужно параллельно несколько клиентов, то client - редактирование конфигурации - allow parallel run
    }
}
