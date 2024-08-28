import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_8885 {

    static int pos = 1;

    static int x = 0;

    static byte[] codeBase = {-35,41,82,-102,-127,-7,93,5,-58,-103};

    static int pc = -273254914;

    int u2AtPut(int pos, int x) {
        codeBase[pc + pos + 0] = (byte) (x >> 8);
        codeBase[pc + pos + 1] = (byte) (x >> 0);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8885().u2AtPut(pos, x);
    }
}
