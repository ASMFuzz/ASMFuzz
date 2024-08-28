import java.io.*;

public class MyJVMTest_12043 {

    static int j = 0;

    boolean cons(int i) {
        switch(b[i]) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return false;
            case 'y':
                return (i == 0) ? true : !cons(i - 1);
            default:
                return true;
        }
    }

    static char[] b = {'N',':','0',Character.MIN_VALUE,'3','g','4',']',Character.MIN_VALUE,Character.MIN_VALUE};

    static int i = 0, i_end = 754866003, j = 0, k = 2;

    static int INC = 50;

    boolean doublec(int j) {
        if (j < 1)
            return false;
        if (b[j] != b[j - 1])
            return false;
        return cons(j);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12043().doublec(j));
    }
}
