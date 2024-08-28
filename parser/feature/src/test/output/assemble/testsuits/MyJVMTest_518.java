import java.io.*;

public class MyJVMTest_518 {

    static String s = "?rLVHVL~2=";

    static char[] b = {'0',Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0',Character.MAX_VALUE,'>'};

    static int i = -1285746663, i_end = 0, j = 4, k = 0;

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
        System.out.println(new MyJVMTest_518().ends(s));
    }
}
