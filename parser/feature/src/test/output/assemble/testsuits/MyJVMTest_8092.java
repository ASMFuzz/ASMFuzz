import java.io.*;

public class MyJVMTest_8092 {

    static char[] w = { Character.MIN_VALUE, 'L', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '%', Character.MAX_VALUE };

    static int wLen = 2;

    static char[] b = {'0',Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'J','0','0',Character.MAX_VALUE,Character.MIN_VALUE};

    static int i = 2, i_end = -66691745, j = 2, k = 0;

    static int INC = 50;

    int add(char[] w, int wLen) {
        if (i + wLen >= b.length) {
            char[] new_b = new char[i + wLen + INC];
            for (int c = 0; c < i; c++) new_b[c] = b[c];
            b = new_b;
        }
        for (int c = 0; c < wLen; c++) b[i++] = w[c];
        return wLen;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8092().add(w, wLen);
    }
}
