import java.util.*;

public class MyJVMTest_15484 {

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

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String FRACTIONAL_ALL_NINES_BENCH = "benchFormatFractionalAllNines";

    static String ALL_NINES_BENCH = "benchFormatAllNines";

    static String name = "!Y6b)Cx-U8";

    void calculateFractionalAllNinesThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = fractionalAllNinesThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + FRACTIONAL_ALL_NINES_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15484().calculateFractionalAllNinesThroughputLoad();
    }
}
