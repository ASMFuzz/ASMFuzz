import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_9036 {

    static int n = 0;

    static byte[] codeBase = {2,-106,-78,-53,-63,106,-115,78,-63,-78};

    static int pc = 3;

    int alignedIntOffset(int n) {
        int pos = pc + 1;
        pos += ((-pos) & 0x03);
        pos += (n * 4);
        return pos - pc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9036().alignedIntOffset(n));
    }
}
