import com.sun.net.httpserver.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_15602 {

    static HttpExchange t = null;

    static int invocation = 1;

    InputStream handle(HttpExchange t) throws IOException {
        InputStream is;
        OutputStream os;
        switch(invocation++) {
            case 1:
                is = t.getRequestBody();
                while (is.read() != -1) ;
                is.close();
                t.sendResponseHeaders(200, "hello".length());
                os = t.getResponseBody();
                os.write("hello".getBytes());
                os.close();
                break;
            case 2:
                is = t.getRequestBody();
                while (is.read() != -1) ;
                is.close();
                t.sendResponseHeaders(200, 0);
                os = t.getResponseBody();
                os.write("hello world".getBytes());
                os.close();
                break;
        }
        return is;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15602().handle(t);
    }
}
