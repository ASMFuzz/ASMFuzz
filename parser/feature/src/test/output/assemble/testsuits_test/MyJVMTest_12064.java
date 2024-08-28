import java.io.*;

public class MyJVMTest_12064 {

    static int count = 7;

    static byte[] orig = {113,-38,106,93,66,-94,-2,-128,71,60};

    static byte[] sdeAttr = {32,-119,125,-110,-112,-8,91,-62,-12,-95};

    static byte[] gen = {-36,112,27,-43,87,108,-117,84,100,-41};

    static int origPos = 0;

    static int genPos = 0;

    int copy(int count) {
        for (int i = 0; i < count; ++i) {
            gen[genPos++] = orig[origPos++];
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12064().copy(count);
    }
}
