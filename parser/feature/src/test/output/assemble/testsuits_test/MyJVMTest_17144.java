import java.util.*;
import java.io.*;

public class MyJVMTest_17144 {

    double nextDouble() {
        switch(rnd.nextInt(20)) {
            case 0:
                return 0;
            case 1:
                return -0.0;
            case 2:
                return Double.MIN_VALUE;
            case 3:
                return Double.MAX_VALUE;
            case 4:
                return Double.NaN;
            case 5:
                return Double.NEGATIVE_INFINITY;
            case 6:
                return Double.POSITIVE_INFINITY;
            case 7:
            case 8:
            case 9:
                return (rnd.nextInt(20) - 10);
            default:
                return rnd.nextDouble();
        }
    }

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

    Object nextObject() {
        switch(rnd.nextInt(10)) {
            case 0:
                return null;
            case 1:
                return "foo";
            case 2:
            case 3:
            case 4:
                return Double.valueOf(nextDouble());
            default:
                return Integer.valueOf(nextInt());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17144().nextObject());
    }
}
