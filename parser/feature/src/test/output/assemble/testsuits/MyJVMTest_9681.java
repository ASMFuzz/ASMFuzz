import java.io.*;

public class MyJVMTest_9681 {

    static String s = "}Tfp/s7@R@";

    static char[] b = {Character.MAX_VALUE,Character.MIN_VALUE,'0',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0','0',Character.MIN_VALUE,'f'};

    static int i = 7, i_end = 0, j = 7, k = 8;

    static int INC = 50;

    boolean ends(String s) {
        int l = s.length();
        int o = k - l + 1;
        if (o < 0)
            return false;
        for (int i = 0; i < l; i++) if (b[o + i] != s.charAt(i))
            return false;
        j = k - l;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9681().ends(s));
    }
}
