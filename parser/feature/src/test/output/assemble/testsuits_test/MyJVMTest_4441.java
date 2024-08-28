import java.net.*;
import java.io.*;
import java.util.*;
import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_4441 {

    static HttpExchange exchange = null;

    HttpExchange handle(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, -1);
        exchange.close();
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4441().handle(exchange);
    }
}
