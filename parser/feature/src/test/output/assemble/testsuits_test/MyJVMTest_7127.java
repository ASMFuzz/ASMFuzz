import com.sun.net.httpserver.HttpExchange;

public class MyJVMTest_7127 {

    static HttpExchange exchange = null;

    HttpExchange handle(HttpExchange exchange) {
        throw new RuntimeException("MyHttpHandlerB.test() must not be able to invoke this method");
        return exchange;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7127().handle(exchange);
    }
}
