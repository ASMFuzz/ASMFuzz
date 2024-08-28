import java.util.*;
import java.io.*;

public class MyJVMTest_6635 {

    int nextInt() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Integer.MIN_VALUE;
            case 2:
                return Integer.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return rnd.nextInt(20) - 10;
            default:
                return rnd.nextInt();
        }
    }

    static Random rnd = new Random();

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

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6635().nextChar());
    }
}
