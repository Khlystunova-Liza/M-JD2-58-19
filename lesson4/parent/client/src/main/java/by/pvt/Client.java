package by.pvt;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client {

    private static Logger log = Logger.getLogger("by.pvt.Client");

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost",3036)
        ){
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(System.in);
            DataOutputStream dataOutputStream =
                    new DataOutputStream(outputStream);
            DataInputStream dataInputStream =
                    new DataInputStream(inputStream);
            String command = "";
            while (!"END".equals(command)) {
                command = scanner.nextLine();
                dataOutputStream.writeUTF(command);
                dataOutputStream.flush();
                String serverResponse = dataInputStream.readUTF();
                log.info(serverResponse);
            }
            dataOutputStream.close();
            dataInputStream.close();

        } catch (IOException e) {//ошибка при потери соединения
            e.printStackTrace();
        }

    }
}
