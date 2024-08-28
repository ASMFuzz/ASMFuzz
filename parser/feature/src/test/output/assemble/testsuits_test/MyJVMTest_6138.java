import java.util.*;
import java.io.*;

public class MyJVMTest_6138 {

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

    byte nextByte() {
        switch(rnd.nextInt(10)) {
            case 0:
                return 0;
            case 1:
                return Byte.MIN_VALUE;
            case 2:
                return Byte.MAX_VALUE;
            case 3:
            case 4:
            case 5:
                return (byte) (rnd.nextInt(20) - 10);
            default:
                return (byte) rnd.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6138().nextByte());
    }
}
