import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.applet.Applet;

public class MyJVMTest_4984 {

    static boolean bOK = false;

    static Thread badThread = null;

    void run() {
        try {
            Thread.sleep(9000);
        } catch (Exception ex) {
        }
        if (!bOK) {
            Runtime.getRuntime().halt(0);
        } else {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4984().run();
    }
}
