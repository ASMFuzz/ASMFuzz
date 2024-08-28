import java.util.*;

public class MyJVMTest_18035 {

    double fairSimpleThroughputLoad() {
        double seed = 0.00010203040506070809;
        double delta = 0.0d;
        double d = (double) -MAX_RANGE;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = d + 1.0d + seed;
        }
        return d;
    }

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String FAIR_SIMPLE_BENCH = "benchFormatFairSimple";

    static String name = "9_W6(qd>4R";

    void calculateFairSimpleThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = fairSimpleThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + FAIR_SIMPLE_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18035().calculateFairSimpleThroughputLoad();
    }
}
