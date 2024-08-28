import java.io.*;

public class MyJVMTest_2537 {

    static char ch = '3';

    static char[] b = {Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'(',Character.MIN_VALUE,'0',Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0'};

    static int i = 0, i_end = 0, j = 0, k = 2;

    static int INC = 50;

    char add(char ch) {
        if (i == b.length) {
            char[] new_b = new char[i + INC];
            for (int c = 0; c < i; c++) new_b[c] = b[c];
            b = new_b;
        }
        b[i++] = ch;
        return ch;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2537().add(ch);
    }
}
