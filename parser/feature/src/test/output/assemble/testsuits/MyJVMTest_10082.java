import java.util.*;

public class MyJVMTest_10082 {

    static int MAX_RANGE = 500000;

    static String name = "?v|v^B/( O";

    double fractionalAllNinesThroughputLoad() {
        double fractionalEven = 0.99930000001;
        double fractionalOdd = 0.99960000001;
        double fractional;
        double d = 0.0d;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            if ((j & 1) == 0)
                fractional = fractionalEven;
            else
                fractional = fractionalOdd;
            if (j >= 0)
                d = (double) j + fractional;
            else
                d = (double) j - fractional;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10082().fractionalAllNinesThroughputLoad());
    }
}
