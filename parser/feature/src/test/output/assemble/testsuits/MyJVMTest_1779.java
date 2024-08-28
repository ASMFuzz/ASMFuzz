import java.util.*;
import java.nio.*;

public class MyJVMTest_1779 {

    static int sum = 0;

    static String name = ",N 1$\"\"UAf";

    int deoptimize(int sum) {
        if (sum == 42)
            System.out.println("the answer");
        return sum;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1779().deoptimize(sum);
    }
}
