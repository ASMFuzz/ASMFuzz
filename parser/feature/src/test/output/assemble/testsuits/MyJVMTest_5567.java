import java.io.*;

public class MyJVMTest_5567 {

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

    static char[] b = {Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,'Y',Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'0','0','c'};

    static int i = 5, i_end = 4, j = 4, k = -400142070;

    static int INC = 50;

    int m() {
        int n = 0;
        int i = 0;
        while (true) {
            if (i > j)
                return n;
            if (!cons(i))
                break;
            i++;
        }
        i++;
        while (true) {
            while (true) {
                if (i > j)
                    return n;
                if (cons(i))
                    break;
                i++;
            }
            i++;
            n++;
            while (true) {
                if (i > j)
                    return n;
                if (!cons(i))
                    break;
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5567().m());
    }
}
