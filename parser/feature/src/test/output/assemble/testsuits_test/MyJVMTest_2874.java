import java.net.*;
import java.io.*;
import java.util.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_2874 {

    static HttpExchange exchange = null;

    HttpExchange handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Location", "/redirect");
        exchange.sendResponseHeaders(302, -1);
        exchange.close();
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2874().handle(exchange);
    }
}
