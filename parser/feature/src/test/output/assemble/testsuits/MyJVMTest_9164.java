import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.interfaces.*;

public class MyJVMTest_9164 {

    static String str = "#dp#]`Y~y0";

    static boolean debug = true;

    static SSLContext sslc = null;

    String log(String str) {
        if (debug) {
            System.out.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9164().log(str);
    }
}
