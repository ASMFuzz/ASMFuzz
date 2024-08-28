public class MyJVMTest_17512 {

    long getVariance() {
        long variance = 0;
        if (count > 1) {
            variance = ((count * sumOfSquares) - (sum * sum)) / (count * (count - 1));
        }
        return variance;
    }

    static long count = -6035108227129555667L, maximum = 0, minimum = -9223372036854775808L, sum = -9223372036854775808L, sumOfSquares = 9223372036854775807L;

    static String variableName = "O/Bz2b;i,W";

    long getStandardDeviation() {
        return (long) java.lang.Math.sqrt(getVariance());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17512().getStandardDeviation());
    }
}
