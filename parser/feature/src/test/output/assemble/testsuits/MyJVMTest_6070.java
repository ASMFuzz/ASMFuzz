import java.io.*;
import java.net.*;
import java.applet.Applet;

public class MyJVMTest_6070 {

    static InetAddress i = null;

    int peek(InetAddress i) throws IOException {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6070().peek(i));
    }
}
