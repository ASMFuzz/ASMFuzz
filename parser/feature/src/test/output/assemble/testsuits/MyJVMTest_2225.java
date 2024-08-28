import java.util.*;

public class MyJVMTest_2225 {

    static long[] times = { 0, 9139224184830799074L, 8795986652107693057L, 9223372036854775807L, -8699342231812536538L, 8316162192699995231L, 0, -9223372036854775808L, 9223372036854775807L, 0 };

    static String benchName = "Gl*kfB8'6P";

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static String name = "J?Q;Z)e*%\\";

    int printPerfResults(long[] times, String benchName) {
        int nbBenches = times.length;
        long totalTimeSpent = 0;
        long meanTimeSpent;
        double variance = 0;
        double standardDeviation = 0;
        for (int i = 1; i <= nbBenches; i++) totalTimeSpent += times[i - 1];
        meanTimeSpent = totalTimeSpent / nbBenches;
        for (int j = 1; j <= nbBenches; j++) variance += Math.pow(((double) times[j - 1] - (double) meanTimeSpent), 2);
        variance = variance / (double) times.length;
        standardDeviation = Math.sqrt(variance) / meanTimeSpent;
        System.out.println("Statistics (starting at 4th bench) for bench " + benchName + "\n for last " + nbBenches + " runs out of " + NB_RUNS + " , each with 2x" + MAX_RANGE + " format(double) calls : " + "\n  mean exec time = " + meanTimeSpent + " microseconds" + "\n  standard deviation = " + String.format("%.3f", standardDeviation) + "% \n");
        return nbBenches;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2225().printPerfResults(times, benchName);
    }
}
