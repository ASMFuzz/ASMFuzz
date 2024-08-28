import java.util.*;
import java.io.*;

public class MyJVMTest_12721 {

    static int length = 1;

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

    static Random rnd = new Random();

    byte[] byteArray(int length) {
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextByte();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12721().byteArray(length)));
    }
}
