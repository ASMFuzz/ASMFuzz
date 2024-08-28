import java.io.PrintStream;
import java.io.File;

public class MyJVMTest_4946 {

    static String outputParam1Param1 = "R0%sW[ C?#";

    static String outputParam1Param2 = "Rc7`Y%cO*e";

    static File outputParam1 = new File(outputParam1Param1, outputParam1Param2);

    static String outputParam2 = ">MSSckNjig";

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

    static long count = 0, maximum = -9223372036854775808L, minimum = -9223372036854775808L, sum = -9223372036854775808L, sumOfSquares = 9223372036854775807L;

    static String variableName = ",nCo.gwf3g";

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
        new MyJVMTest_4946().printStatistics(output);
    }
}
