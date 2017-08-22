package server;

import api.SayHello;
import api.impl.SayHelloImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 123 on 2017/08/21.
 */

public class myServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());

        while (true) {
           String readLine = br.readLine();
            System.out.println("服务端发过来的" + readLine);
            SayHello sayHello = new SayHelloImpl();
            String  say= sayHello.sayHello(readLine);
            pw.println(say);
            pw.flush();
            break;
        }

    }
}
