import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_14385 {

    static int pos = 7;

    static byte[] codeBase = {-51,-81,40,70,8,-3,-52,-74,-33,38};

    static int pc = 0;

    int u1At(int pos) {
        return (codeBase[pc + pos] & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14385().u1At(pos));
    }
}
