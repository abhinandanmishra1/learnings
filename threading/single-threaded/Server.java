import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void run() throws IOException {
        int PORT = 8010;
        ServerSocket socket = new ServerSocket(PORT);
        socket.setSoTimeout(10000);

        while(true) {
            System.out.println("Server is listening on port: " + PORT);

            Socket connectedSocket = socket.accept();
            System.out.println("Connection established at address:" +  connectedSocket.getRemoteSocketAddress());
            PrintWriter writeToClient = new PrintWriter(connectedSocket.getOutputStream());
            BufferedReader readFromClient = new BufferedReader(new InputStreamReader(connectedSocket.getInputStream()));

            writeToClient.write("Hi bro, i am server");
            writeToClient.close();
            readFromClient.close();
            connectedSocket.close();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();

        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

