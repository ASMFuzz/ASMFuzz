import java.util.*;

public class MyJVMTest_2832 {

    double smallIntegralThroughputLoad() {
        double d = 0.0d;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = (double) j / 1000.0d;
        }
        return d;
    }

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String SMALL_INTEGRAL_BENCH = "benchFormatSmallIntegral";

    static String name = "}1v^rv7L\\A";

    void calculateSmallIntegralThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = smallIntegralThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + SMALL_INTEGRAL_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2832().calculateSmallIntegralThroughputLoad();
    }
}
