import java.net.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_2039 {

    static int[] i = { -874657771, 7, 0, 6, 4, 0, 0, -555517507, -311697843, -1586270854 };

    byte[] bytes(int[] i) {
        byte[] buf = new byte[i.length];
        for (int j = 0; j < i.length; j++) {
            buf[j] = (byte) i[j];
        }
        return buf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2039().bytes(i)));
    }
}
