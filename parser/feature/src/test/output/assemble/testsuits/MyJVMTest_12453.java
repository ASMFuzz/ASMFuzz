import java.io.*;

public class MyJVMTest_12453 {

    static byte[] bytes = { 17, 97, 122, -27, -42, -19, 96, -60, -98, 29 };

    static byte[] orig = {64,-15,7,-59,30,-45,112,32,30,70};

    static byte[] sdeAttr = {100,-99,63,-59,39,17,-109,-62,94,-110};

    static byte[] gen = {-51,21,21,58,-121,117,23,84,-124,-29};

    static int genPos = 0;

    byte[] writeBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; ++i) {
            gen[genPos++] = bytes[i];
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12453().writeBytes(bytes);
    }
}
