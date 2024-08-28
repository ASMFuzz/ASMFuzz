import java.util.*;

public class MyJVMTest_1703 {

    static int MAX_RANGE = 500000;

    static String name = "gDsF6V=?r,";

    double smallIntegralThroughputLoad() {
        double d = 0.0d;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = (double) j / 1000.0d;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1703().smallIntegralThroughputLoad());
    }
}
