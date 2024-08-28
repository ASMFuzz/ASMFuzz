import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_4979 {

    static int pos = 0;

    static byte[] codeBase = {-74,35,83,96,19,-22,-78,-50,-118,-100};

    static int pc = 0;

    int u1At(int pos) {
        return (codeBase[pc + pos] & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4979().u1At(pos));
    }
}
