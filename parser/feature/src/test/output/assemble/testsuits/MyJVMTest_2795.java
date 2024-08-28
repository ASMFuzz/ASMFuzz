import java.util.*;

public class MyJVMTest_2795 {

    static int MAX_RANGE = 500000;

    static String name = "m/hE-gVm{Z";

    double fractionalThroughputLoad() {
        double d = 0.0d;
        double floatingN = 1.0d / (double) MAX_RANGE;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = floatingN * (double) j;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2795().fractionalThroughputLoad());
    }
}
