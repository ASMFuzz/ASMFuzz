import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class MyJVMTest_15565 {

    static SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

    SocketFactory getDefault() {
        System.err.println("DeadSSLSocketFactory: acquiring DeadSSLSocketFactory as default socket factory");
        return new DeadSSLSocketFactory();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15565().getDefault());
    }
}
