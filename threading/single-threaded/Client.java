import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void run() throws UnknownHostException, IOException {
        int PORT = 8010;

        InetAddress address = InetAddress.getByName("localhost");

        Socket socket = new Socket(address, PORT);
        PrintWriter writeToServer = new PrintWriter(socket.getOutputStream());
        BufferedReader readFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writeToServer.write("Hello bro, I am client");
        System.out.println(readFromServer.readLine());
        writeToServer.close();
        readFromServer.close();
        socket.close();
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

