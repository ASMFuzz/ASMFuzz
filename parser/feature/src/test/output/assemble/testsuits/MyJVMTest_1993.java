import java.net.*;
import java.io.*;

public class MyJVMTest_1993 {

    static URL _url = null;

    static URLConnection _conn = null;

    OutputStream getBody() throws IOException {
        System.out.println("getBody called");
        return new DeployByteArrayOutputStream(_url, _conn);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1993().getBody());
    }
}
