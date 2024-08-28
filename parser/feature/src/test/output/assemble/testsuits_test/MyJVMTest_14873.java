import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;

public class MyJVMTest_14873 {

    static String host = "*@@$PMkFUe";

    static int port = 1384463063;

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
        System.out.println(new MyJVMTest_14873().createSocket(host, port));
    }
}
