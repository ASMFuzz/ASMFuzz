import java.util.*;
import java.io.*;

public class MyJVMTest_5214 {

    static int length = 562165484;

    boolean nextBoolean() {
        return rnd.nextBoolean();
    }

    static Random rnd = new Random();

    boolean[] booleanArray(int length) {
        boolean[] result = new boolean[length];
        for (int i = 0; i < length; i++) result[i] = Rnd.nextBoolean();
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5214().booleanArray(length)));
    }
}
