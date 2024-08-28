import java.io.*;

public class MyJVMTest_7583 {

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

    static char[] b = {'0','k','0','0',Character.MAX_VALUE,'0','x','u',Character.MAX_VALUE,'D'};

    static int i = 0, i_end = 2, j = 1091590036, k = 95335811;

    static int INC = 50;

    boolean cvc(int i) {
        if (i < 2 || !cons(i) || cons(i - 1) || !cons(i - 2))
            return false;
        {
            int ch = b[i];
            if (ch == 'w' || ch == 'x' || ch == 'y')
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7583().cvc(i));
    }
}
