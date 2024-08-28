import com.sun.net.httpserver.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_6407 {

    static HttpExchange t = null;

    static CountDownLatch finished = null;

    HttpExchange handle(HttpExchange t) throws IOException {
        try (InputStream is = t.getRequestBody()) {
            Headers map = t.getRequestHeaders();
            Headers rmap = t.getResponseHeaders();
            while (is.read() != -1) ;
        }
        t.sendResponseHeaders(200, -1);
        t.close();
        finished.countDown();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6407().handle(t);
    }
}
