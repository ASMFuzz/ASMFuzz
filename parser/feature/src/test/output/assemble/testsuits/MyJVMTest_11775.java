import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class MyJVMTest_11775 {

    static int size = 6;

    static int cnt = 0;

    int read() {
        if (cnt < size) {
            cnt++;
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11775().read());
    }
}
