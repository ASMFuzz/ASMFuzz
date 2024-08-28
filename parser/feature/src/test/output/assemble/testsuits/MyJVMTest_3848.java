import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_3848 {

    static String cipherSuite = "Og)NUk#[U|";

    static String protocol = "y/wRf?CPM4";

    static String clientAuth = ">lMnG2^O0e";

    static int supportedSince = 0;

    static int obsoletedSince = -339208191;

    int toVersionNumber(String protocol) {
        int versionNumber = -1;
        switch(protocol) {
            case "SSLv2Hello":
                versionNumber = 0x0002;
                break;
            case "SSLv3":
                versionNumber = 0x0300;
                break;
            case "TLSv1":
                versionNumber = 0x0301;
                break;
            case "TLSv1.1":
                versionNumber = 0x0302;
                break;
            case "TLSv1.2":
                versionNumber = 0x0303;
                break;
            default:
        }
        return versionNumber;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3848().toVersionNumber(protocol));
    }
}
