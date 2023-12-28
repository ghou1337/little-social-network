package pl.test.social.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
class ServerController {

    @GetMapping("/start-server")
    public void startServer() {
        int port = 12345;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер слушает на порту " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключен клиент " + clientSocket.getInetAddress());

                executorService.submit(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            // Здесь можно обрабатывать данные от клиента
            // Пример: считывание данных из InputStream
             InputStream inputStream = clientSocket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             String data = reader.readLine();
             System.out.println("Получены данные: " + data);

            // В данном примере, мы просто закрываем соединение
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
