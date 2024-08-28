import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_8860 {

    static int pos = 939188613;

    static byte[] codeBase = {-32,88,115,16,-42,46,92,-73,-73,84};

    static int pc = 7;

    int u1At(int pos) {
        return (codeBase[pc + pos] & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8860().u1At(pos));
    }
}
