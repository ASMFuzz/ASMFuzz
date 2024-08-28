import java.util.*;

public class MyJVMTest_12448 {

    static int MAX_RANGE = 500000;

    static String name = "84D]GR-5nu";

    double allNinesThroughputLoad() {
        double[] decimaAllNines = { 9.9993, 99.9993, 999.9993, 9999.9993, 99999.9993, 999999.9993, 9999999.9993, 99999999.9993, 999999999.9993 };
        double[] valuesArray = decimaAllNines;
        double seed = 1.0 / (double) MAX_RANGE;
        double d = 0.0d;
        int id;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            id = (j >= 0) ? j % 9 : -j % 9;
            if ((j & 1) == 0)
                d = valuesArray[id] + id * seed;
            else
                d = valuesArray[id] - id * seed;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12448().allNinesThroughputLoad());
    }
}
