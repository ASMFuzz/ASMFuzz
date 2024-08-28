import java.io.*;

public class MyJVMTest_17128 {

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

    static char[] b = {Character.MAX_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,'0','0',Character.MIN_VALUE,'0','0'};

    static int i = -702197011, i_end = 0, j = 4, k = 0;

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
        System.out.println(new MyJVMTest_17128().cvc(i));
    }
}
