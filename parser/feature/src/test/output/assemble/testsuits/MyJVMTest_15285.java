import java.io.*;

public class MyJVMTest_15285 {

    int readU1() {
        return ((int) orig[origPos++]) & 0xFF;
    }

    static byte[] orig = {34,-62,60,-47,-11,-88,40,13,-125,-83};

    static byte[] sdeAttr = {1,123,76,9,3,-16,-87,-72,58,-12};

    static byte[] gen = {-57,85,47,56,-94,48,68,-94,88,115};

    static int origPos = 0;

    static int genPos = 0;

    int readU2() {
        int res = readU1();
        return (res << 8) + readU1();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15285().readU2());
    }
}
