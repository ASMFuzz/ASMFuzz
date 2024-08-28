import java.io.*;

public class MyJVMTest_9996 {

    static boolean[] bits = { false, true, false, true, true, false, false, true, false, false };

    int count(boolean[] bits) {
        int count = 0;
        for (int i = 0; i < bits.length; i++) count += bits[i] ? 1 : 0;
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9996().count(bits));
    }
}
