import java.util.*;

public class MyJVMTest_9334 {

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

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static boolean Verbose = false;

    static String ALL_NINES_BENCH = "benchFormatAllNines";

    static String name = "rclMatj!Ey";

    void calculateAllNinesThroughputLoad() {
        int nbRuns = NB_RUNS;
        long elapsedTime = 0;
        double foo;
        for (int i = 1; i <= nbRuns; i++) {
            long startTime = System.nanoTime();
            foo = allNinesThroughputLoad();
            long estimatedTime = System.nanoTime() - startTime;
            if (i > 3)
                elapsedTime += estimatedTime / 1000;
        }
        if (Verbose)
            System.out.println("calculated throughput load for " + ALL_NINES_BENCH + " bench is = " + (elapsedTime / (nbRuns - 3)) + " microseconds");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9334().calculateAllNinesThroughputLoad();
    }
}
