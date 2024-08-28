import java.util.*;

public class MyJVMTest_16350 {

    static boolean isCurrency = true;

    double tieThroughputLoad(boolean isCurrency) {
        double d = 0.0d;
        double fractionaScaling = (isCurrency) ? 1000.0d : 10000.0d;
        int fixedFractionalPart = (isCurrency) ? 125 : 1235;
        for (int j = -MAX_RANGE; j <= MAX_RANGE; j++) {
            d = (((double) j * fractionaScaling) + (double) fixedFractionalPart) / fractionaScaling;
        }
        return d;
    }

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String TIE_BENCH = "benchFormatTie";

    static String name = "Zop[Imuu9O";

    long calculateTieThroughputLoad(boolean isCurrency) {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = tieThroughputLoad(isCurrency);
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + TIE_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
        return elapsedTime;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16350().calculateTieThroughputLoad(isCurrency);
    }
}
