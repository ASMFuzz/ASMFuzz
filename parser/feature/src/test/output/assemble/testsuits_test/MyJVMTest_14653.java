import java.io.*;

public class MyJVMTest_14653 {

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

    static char[] b = {Character.MIN_VALUE,'8',Character.MIN_VALUE,'0','>',Character.MIN_VALUE,Character.MAX_VALUE,Character.MIN_VALUE,Character.MIN_VALUE,'1'};

    static int i = 4, i_end = 0, j = 5, k = 0;

    static int INC = 50;

    boolean vowelinstem() {
        int i;
        for (i = 0; i <= j; i++) if (!cons(i))
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14653().vowelinstem());
    }
}
