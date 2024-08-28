import java.io.*;

public class MyJVMTest_817 {

    static boolean[] bits = { true, true, false, true, false, true, true, false, true, true };

    int count(boolean[] bits) {
        int count = 0;
        for (int i = 0; i < bits.length; i++) count += bits[i] ? 1 : 0;
        return count;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_817().count(bits));
    }
}
