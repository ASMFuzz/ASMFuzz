import java.io.*;

public class MyJVMTest_5839 {

    int readU1() {
        return ((int) orig[origPos++]) & 0xFF;
    }

    static byte[] orig = {-10,-77,-122,51,112,-104,-45,-4,47,17};

    static byte[] sdeAttr = {-88,54,74,-49,-87,-65,122,-123,126,92};

    static byte[] gen = {95,41,116,-78,29,-15,-60,8,86,82};

    static int origPos = 0;

    static int genPos = 0;

    int readU2() {
        int res = readU1();
        return (res << 8) + readU1();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5839().readU2());
    }
}
