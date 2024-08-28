import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_5422 {

    static int n = 1;

    static byte[] codeBase = {-59,-117,69,-76,72,47,-73,126,3,65};

    static int pc = -1849586034;

    int alignedIntOffset(int n) {
        int pos = pc + 1;
        pos += ((-pos) & 0x03);
        pos += (n * 4);
        return pos - pc;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5422().alignedIntOffset(n));
    }
}
