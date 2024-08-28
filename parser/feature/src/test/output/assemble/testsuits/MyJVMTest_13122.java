import java.net.*;
import java.io.*;
import java.util.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_13122 {

    static HttpExchange exchange = null;

    static URL _url = null;

    static URLConnection _conn = null;

    static InputStream is = null;

    static Map<String, List<String>> headers = new HashMap<String,List<String>>();

    HttpExchange handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Location", "/redirect");
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13122().handle(exchange);
    }
}
