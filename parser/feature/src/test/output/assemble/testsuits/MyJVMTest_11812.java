import java.io.*;

public class MyJVMTest_11812 {

    static char ch = Character.MAX_VALUE;

    static char[] b = {Character.MIN_VALUE,Character.MIN_VALUE,'E',Character.MIN_VALUE,Character.MAX_VALUE,Character.MAX_VALUE,'0',Character.MAX_VALUE,'7',')'};

    static int i = 0, i_end = 0, j = -957459072, k = 1968284202;

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
        new MyJVMTest_11812().add(ch);
    }
}
