import java.util.*;

public class MyJVMTest_8589 {

    static int MAX_RANGE = 500000;

    static String name = ".'39cuZ9h0";

    double integerThroughputLoad() {
        double d = 0.0d;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = (double) j;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8589().integerThroughputLoad());
    }
}
