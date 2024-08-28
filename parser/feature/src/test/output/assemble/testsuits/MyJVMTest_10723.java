import java.util.*;

public class MyJVMTest_10723 {

    static int MAX_RANGE = 500000;

    static String name = "W07>KRM[UD";

    double fairSimpleThroughputLoad() {
        double seed = 0.00010203040506070809;
        double delta = 0.0d;
        double d = (double) -MAX_RANGE;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = d + 1.0d + seed;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10723().fairSimpleThroughputLoad());
    }
}
