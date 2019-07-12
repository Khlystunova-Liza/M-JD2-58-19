package by.pvt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    private static Logger log = Logger.getLogger("by.pvt.Server");

    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(3036)
        ){

            ExecutorService service = Executors.newCachedThreadPool();
            do {
                Socket socket = serverSocket.accept();//сервер ждет подключения клиента, когда клиент подключается, сервер возвращает обьект socket
                final DataInputStream datainputStream =
                        new DataInputStream(socket.getInputStream());
                final DataOutputStream dataOutputStream =
                        new DataOutputStream(socket.getOutputStream());
                service.submit(()->{
                    try{
                    String response = "";
                    while (!"END".equals(response)) {
                        response = datainputStream.readUTF();
                        log.info("Client response for server: " + response);
                        dataOutputStream.writeUTF("Server request for client: " + response );
                        dataOutputStream.flush();
                    }}catch (IOException e){
                      log.log(Level.SEVERE,  e.getMessage(),e);
                    }
                });
            }while(true);
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
