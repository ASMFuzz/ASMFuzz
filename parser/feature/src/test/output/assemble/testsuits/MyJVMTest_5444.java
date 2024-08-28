import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_5444 {

    static String host = "$l:c5Qe6UL";

    static int port = 0;

    static int flakeFactor = 0;

    static int flakeState = 0;

    static int createCount = 0;

    Socket createSocket(String host, int port) throws IOException {
        createCount++;
        if (++flakeState > flakeFactor) {
            flakeState = 0;
        }
        if (flakeState == 0) {
            return new Socket(host, port);
        } else {
            throw new IOException("random network failure");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5444().createSocket(host, port));
    }
}
