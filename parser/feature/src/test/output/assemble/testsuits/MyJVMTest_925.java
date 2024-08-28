import javax.crypto.*;
import javax.net.ssl.*;
import javax.net.ssl.SSLEngineResult.*;
import java.io.*;
import java.nio.*;
import java.security.*;

public class MyJVMTest_925 {

    static String str = "#8$xW>Zj!x";

    static boolean debug = false;

    String log(String str) {
        if (debug) {
            System.out.println(str);
        }
        return str;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_925().log(str);
    }
}
