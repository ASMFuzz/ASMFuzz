import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;

public class MyJVMTest_220 {

    static HttpExchange t = null;

    HttpExchange handle(HttpExchange t) throws IOException {
        InputStream is = t.getRequestBody();
        Headers map = t.getRequestHeaders();
        Headers rmap = t.getResponseHeaders();
        while (is.read() != -1) ;
        is.close();
        t.sendResponseHeaders(200, -1);
        t.close();
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_220().handle(t);
    }
}
