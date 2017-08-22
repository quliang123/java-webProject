package client;

import api.SayHello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by 123 on 2017/08/21.
 */

public class myClient {

    public static void main(String[] args) throws Exception {
        SayHello sayHello = (SayHello) Remote(SayHello.class);
        String say = sayHello.sayHello("Dog 华");
        System.out.println(say);
    }

    private static Object Remote(Class clazz) {
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost", 8888);
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println((String) args[0]);
                pw.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String result = br.readLine();
                return result;
            }
        });
    }
}
