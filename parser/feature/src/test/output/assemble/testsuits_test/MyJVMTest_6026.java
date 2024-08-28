import java.util.*;

public class MyJVMTest_6026 {

    static int MAX_RANGE = 500000;

    static String name = "*l]K5b6|;3";

    double fairThroughputLoad() {
        double k = 1000.0d / (double) MAX_RANGE;
        k *= k;
        double d = 0.0d;
        double absj;
        double jPowerOf2;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            absj = (double) j;
            jPowerOf2 = absj * absj;
            d = k * jPowerOf2;
            if (j < 0)
                d = -d;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6026().fairThroughputLoad());
    }
}
