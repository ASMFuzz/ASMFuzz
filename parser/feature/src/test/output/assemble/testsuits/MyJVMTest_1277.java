import java.io.*;
import java.net.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_1277 {

    static HttpExchange exchange = null;

    static String reply = "1yuUXeX?bW";

    HttpExchange proxyReply(HttpExchange exchange, String reply) throws IOException {
        exchange.getResponseHeaders().add("Proxy-Authenticate", reply);
        exchange.sendResponseHeaders(407, 0);
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1277().proxyReply(exchange, reply);
    }
}
