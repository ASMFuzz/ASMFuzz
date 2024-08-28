import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_4279 {

    static int pos = 693152174;

    static int x = 7;

    static byte[] codeBase = {-122,47,-107,-98,-110,32,-124,41,-68,-8};

    static int pc = 0;

    int u2AtPut(int pos, int x) {
        codeBase[pc + pos + 0] = (byte) (x >> 8);
        codeBase[pc + pos + 1] = (byte) (x >> 0);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4279().u2AtPut(pos, x);
    }
}
