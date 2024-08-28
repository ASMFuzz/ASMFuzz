import java.util.*;
import java.nio.*;

public class MyJVMTest_11003 {

    static int sum = 1834267036;

    static String name = "ke%~E{q1@{";

    int deoptimize(int sum) {
        if (sum == 42)
            System.out.println("the answer");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11003().deoptimize(sum);
    }
}
