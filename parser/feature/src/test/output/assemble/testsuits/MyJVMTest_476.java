import java.net.*;
import java.io.*;
import java.util.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_476 {

    static HttpExchange exchange = null;

    static URL _url = null;

    static URLConnection _conn = null;

    static InputStream is = null;

    static Map<String, List<String>> headers = new HashMap<String,List<String>>();

    HttpExchange handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, -1);
        exchange.close();
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_476().handle(exchange);
    }
}
