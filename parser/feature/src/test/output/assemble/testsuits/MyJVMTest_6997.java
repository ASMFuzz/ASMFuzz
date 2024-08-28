public class MyJVMTest_6997 {

    static long count = 9223372036854775807L, maximum = -2270828142988921360L, minimum = 0, sum = -9223372036854775808L, sumOfSquares = -9223372036854775808L;

    static String variableName = "k,S=/n`um(";

    long getVariance() {
        long variance = 0;
        if (count > 1) {
            variance = ((count * sumOfSquares) - (sum * sum)) / (count * (count - 1));
        }
        return variance;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6997().getVariance());
    }
}
