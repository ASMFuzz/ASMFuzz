import java.io.*;
import java.util.Arrays;

public class MyJVMTest_11215 {

    static int count = 828736477;

    static byte[] orig = {-84,109,-84,-99,-123,-39,114,-72,-15,51};

    static byte[] sdeAttr = {125,61,23,105,92,-46,-94,-66,-49,5};

    static byte[] gen = {-100,112,80,-44,-39,-68,-112,-14,47,42};

    static int origPos = 0;

    static int genPos = 0;

    byte[] readBytes(int count) {
        byte[] bytes = new byte[count];
        for (int i = 0; i < count; ++i) {
            bytes[i] = orig[origPos++];
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11215().readBytes(count)));
    }
}
