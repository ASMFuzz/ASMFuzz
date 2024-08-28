import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.security.*;
import java.security.cert.*;
import javax.net.ssl.*;

public class MyJVMTest_13190 {

    static String cipherSuite = "Rmug;6_Shl";

    static String protocol = "pzzlwh!.*l";

    static String clientAuth = "t0mV(T.0QA";

    static int supportedSince = -654683270;

    static int obsoletedSince = 0;

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
        System.out.println(new MyJVMTest_13190().toVersionNumber(protocol));
    }
}
