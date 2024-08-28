import java.net.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_11284 {

    static int[] i = { 3, 0, 1951703802, 0, 610621160, 0, 0, 0, 3, 7 };

    byte[] bytes(int[] i) {
        byte[] buf = new byte[i.length];
        for (int j = 0; j < i.length; j++) {
            buf[j] = (byte) i[j];
        }
        return buf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11284().bytes(i)));
    }
}
