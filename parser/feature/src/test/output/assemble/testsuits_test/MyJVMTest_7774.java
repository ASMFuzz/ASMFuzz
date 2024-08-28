import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.security.*;
import java.nio.*;

public class MyJVMTest_7774 {

    static String str = "gUy3.9sFp^";

    static boolean logging = false;

    String log(String str) {
        if (logging) {
            System.err.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7774().log(str);
    }
}
