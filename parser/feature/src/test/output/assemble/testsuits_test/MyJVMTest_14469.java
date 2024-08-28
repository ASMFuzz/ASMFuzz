import java.util.*;
import java.io.*;

public class MyJVMTest_14469 {

    static int length = 7;

    char nextChar() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Character.MIN_VALUE;
            case 2:
                return Character.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return (char) (rnd.nextInt(20) - 10);
            default:
                return (char) rnd.nextInt();
        }
    }

    static Random rnd = new Random();

    char[] charArray(int length) {
        char[] result = new char[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextChar();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14469().charArray(length)));
    }
}
