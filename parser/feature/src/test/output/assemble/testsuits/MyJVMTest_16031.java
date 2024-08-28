import java.util.*;

public class MyJVMTest_16031 {

    static boolean isCurrency = false;

    static int MAX_RANGE = 500000;

    static String name = "7ZoxR@s\\h]";

    double tieThroughputLoad(boolean isCurrency) {
        double d = 0.0d;
        double fractionaScaling = (isCurrency) ? 1000.0d : 10000.0d;
        int fixedFractionalPart = (isCurrency) ? 125 : 1235;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = (((double) j * fractionaScaling) + (double) fixedFractionalPart) / fractionaScaling;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16031().tieThroughputLoad(isCurrency));
    }
}
