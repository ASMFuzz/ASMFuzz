import java.io.*;

public class MyJVMTest_17662 {

    static char[] w = { Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, '0', 'R', '0', Character.MAX_VALUE, Character.MIN_VALUE, '0' };

    static int wLen = 0;

    static char[] b = {Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'0','I',Character.MAX_VALUE,Character.MAX_VALUE,'<','0','4'};

    static int i = 6, i_end = -1058736284, j = 0, k = 7;

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
        new MyJVMTest_17662().add(w, wLen);
    }
}
