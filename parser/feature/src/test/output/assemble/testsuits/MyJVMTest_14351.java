import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_14351 {

    static String outputParam1Param1Param1 = "-Y+WG>15pG";

    static File outputParam1Param1 = new File(outputParam1Param1Param1);

    static String outputParam1Param2 = "5lsurf<JRO";

    static File outputParam1 = new File(outputParam1Param1, outputParam1Param2);

    static String outputParam2 = "Gowem?A0$i";

    static PrintStream output = new PrintStream(outputParam1, outputParam2);

    long getMean() {
        return (count > 0) ? (sum / count) : 0;
    }

    long getVariance() {
        long variance = 0;
        if (count > 1) {
            variance = ((count * sumOfSquares) - (sum * sum)) / (count * (count - 1));
        }
        return variance;
    }

    long getStandardDeviation() {
        return (long) java.lang.Math.sqrt(getVariance());
    }

    static long count = 1413434208715657968L, maximum = -9223372036854775808L, minimum = -4185974513231997685L, sum = 9223372036854775807L, sumOfSquares = -9223372036854775808L;

    static String variableName = "DvVJ6[X]yT";

    PrintStream printStatistics(PrintStream output) {
        output.println("Statistics for " + variableName);
        output.println(variableName + " count = " + count);
        output.println(variableName + " sum = " + sum);
        output.println(variableName + " minimum = " + minimum);
        output.println(variableName + " maximum = " + maximum);
        output.println(variableName + " mean = " + getMean());
        output.println(variableName + " variance = " + getVariance());
        output.println(variableName + " standard deviation = " + getStandardDeviation());
        return output;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14351().printStatistics(output);
    }
}
