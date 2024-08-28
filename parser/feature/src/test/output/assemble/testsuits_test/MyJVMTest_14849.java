import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_14849 {

    static int n = 4;

    static byte[] codeBase = {-12,-37,-128,80,-39,-27,-23,-58,-83,72};

    static int pc = 6;

    int alignedIntOffset(int n) {
        int pos = pc + 1;
        pos += ((-pos) & 0x03);
        pos += (n * 4);
        return pos - pc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14849().alignedIntOffset(n));
    }
}
