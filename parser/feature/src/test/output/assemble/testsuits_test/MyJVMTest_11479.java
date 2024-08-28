import java.util.*;

public class MyJVMTest_11479 {

    static long[] times = { -7679480912754665694L, 9223372036854775807L, 0, 0, 0, 4762673172021294670L, 3083524988365372627L, -9223372036854775808L, 9223372036854775807L, 5540874140778232L };

    static String benchName = "zmy|jzo*0$";

    static int NB_RUNS = 20;

    static int MAX_RANGE = 500000;

    static String name = "`c$@2HCg|n";

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
        new MyJVMTest_11479().printPerfResults(times, benchName);
    }
}
