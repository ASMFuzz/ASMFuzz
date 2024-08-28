import java.io.*;
import java.net.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_10481 {

    static HttpExchange exchange = null;

    static String reply = "l[5&It\"I:y";

    HttpExchange proxyReply(HttpExchange exchange, String reply) throws IOException {
        exchange.getResponseHeaders().add("Proxy-Authenticate", reply);
        exchange.sendResponseHeaders(407, 0);
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10481().proxyReply(exchange, reply);
    }
}
