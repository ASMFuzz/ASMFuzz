import java.io.*;

public class MyJVMTest_1773 {

    static String s = "ig=k*2?hIT";

    static char[] b = {'|','0','^','0',Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE};

    static int i = 1, i_end = 0, j = 5, k = 738114740;

    static int INC = 50;

    int setto(String s) {
        int l = s.length();
        int o = j + 1;
        for (int i = 0; i < l; i++) b[o + i] = s.charAt(i);
        k = j + l;
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1773().setto(s);
    }
}
