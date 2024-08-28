import java.io.*;

public class MyJVMTest_3137 {

    static byte[] bytes = { -22, 5, 43, 85, 96, 7, 21, 93, 38, -125 };

    static byte[] orig = {5,109,59,-16,32,-122,-98,6,20,24};

    static byte[] sdeAttr = {50,75,104,-100,71,-69,26,-107,-44,35};

    static byte[] gen = {17,121,-106,-67,-67,-27,-52,64,95,121};

    static int genPos = 0;

    byte[] writeBytes(byte[] bytes) {
        for (int i = 0; i < bytes.length; ++i) {
            gen[genPos++] = bytes[i];
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3137().writeBytes(bytes);
    }
}
