import java.util.*;

public class MyJVMTest_6115 {

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

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String FAIR_BENCH = "benchFormatFair";

    static String name = "x:W&P$}w a";

    void calculateFairThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = fairThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + FAIR_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6115().calculateFairThroughputLoad();
    }
}
