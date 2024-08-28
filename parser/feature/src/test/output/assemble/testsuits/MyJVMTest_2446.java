import com.sun.net.httpserver.*;
import java.net.*;

public class MyJVMTest_2446 {

    static HttpServer server = null;

    void stopServer() {
        if (server != null) {
            server.stop(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2446().stopServer();
    }
}
