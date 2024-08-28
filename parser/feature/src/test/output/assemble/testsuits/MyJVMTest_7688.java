import java.util.*;

public class MyJVMTest_7688 {

    double fractionalThroughputLoad() {
        double d = 0.0d;
        double floatingN = 1.0d / (double) MAX_RANGE;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = floatingN * (double) j;
        }
        return d;
    }

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String FRACTIONAL_BENCH = "benchFormatFractional";

    static String name = "P@ 5h(vjJ<";

    void calculateFractionalThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = fractionalThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + FRACTIONAL_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7688().calculateFractionalThroughputLoad();
    }
}
