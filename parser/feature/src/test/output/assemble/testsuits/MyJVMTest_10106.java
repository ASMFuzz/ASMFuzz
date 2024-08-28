import javax.crypto.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.*;

public class MyJVMTest_10106 {

    static String str = "AHiZ[,WD\\g";

    static boolean debug = false;

    String log(String str) {
        if (debug) {
            System.out.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10106().log(str);
    }
}
