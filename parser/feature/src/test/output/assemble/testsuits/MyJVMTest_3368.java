import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_3368 {

    static HttpExchange t = null;

    static boolean ok = false;

    static int requests = 0;

    HttpExchange handle(HttpExchange t) throws IOException {
        int count = 0;
        InputStream is = t.getRequestBody();
        Headers map = t.getRequestHeaders();
        Headers rmap = t.getResponseHeaders();
        while (is.read() != -1) {
            count++;
        }
        if (count != 22) {
            System.out.println("Handler expected 22. got " + count);
            ok = false;
        }
        is.close();
        t.sendResponseHeaders(200, -1);
        t.close();
        requests++;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3368().handle(t);
    }
}
