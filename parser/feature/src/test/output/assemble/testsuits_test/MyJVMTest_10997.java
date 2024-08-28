import java.io.*;

public class MyJVMTest_10997 {

    static String s = "R2ZzulX9/<";

    static char[] b = {'0','0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,':','0',Character.MAX_VALUE,Character.MIN_VALUE};

    static int i = 0, i_end = 750815877, j = 7, k = 5;

    static int INC = 50;

    int setto(String s) {
        int l = s.length();
        int o = j + 1;
        for (int i = 0; i < l; i++) b[o + i] = s.charAt(i);
        k = j + l;
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10997().setto(s);
    }
}
