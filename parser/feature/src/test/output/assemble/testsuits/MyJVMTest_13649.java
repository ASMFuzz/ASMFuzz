import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_13649 {

    static int pos = 0;

    static int x = 5;

    static byte[] codeBase = {75,-76,104,-122,-63,122,-97,-60,21,64};

    static int pc = 0;

    int u2AtPut(int pos, int x) {
        codeBase[pc + pos + 0] = (byte) (x >> 8);
        codeBase[pc + pos + 1] = (byte) (x >> 0);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13649().u2AtPut(pos, x);
    }
}
