public class MyJVMTest_16511 {

    static long count = 7347056207559636028L, maximum = 9223372036854775807L, minimum = -9223372036854775808L, sum = 0, sumOfSquares = 9223372036854775807L;

    static String variableName = "aV/KtBAGAa";

    long getVariance() {
        long variance = 0;
        if (count > 1) {
            variance = ((count * sumOfSquares) - (sum * sum)) / (count * (count - 1));
        }
        return variance;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16511().getVariance());
    }
}
