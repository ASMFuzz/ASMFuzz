import java.io.*;

public class MyJVMTest_2752 {

    static int j = 1;

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

    static char[] b = {Character.MIN_VALUE,'0',Character.MAX_VALUE,'0','c','6','0','0','%',Character.MIN_VALUE};

    static int i = -797165124, i_end = -126443629, j = 0, k = -1579287342;

    static int INC = 50;

    boolean doublec(int j) {
        if (j < 1)
            return false;
        if (b[j] != b[j - 1])
            return false;
        return cons(j);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2752().doublec(j));
    }
}
