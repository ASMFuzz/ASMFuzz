import com.sun.net.httpserver.*;
import java.net.*;

public class MyJVMTest_11713 {

    static HttpServer server = null;

    void stopServer() {
        if (server != null) {
            server.stop(0);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11713().stopServer();
    }
}
