import java.io.*;
import java.util.Arrays;

public class MyJVMTest_1977 {

    static int count = 4;

    static byte[] orig = {79,-87,34,31,59,-79,-34,-109,82,-52};

    static byte[] sdeAttr = {26,-91,34,34,83,-37,-88,-15,39,70};

    static byte[] gen = {-3,-95,39,64,-79,-66,34,-26,13,-103};

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
        System.out.println(Arrays.asList(new MyJVMTest_1977().readBytes(count)));
    }
}
