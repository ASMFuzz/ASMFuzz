public class MyJVMTest_7949 {

    long getVariance() {
        long variance = 0;
        if (count > 1) {
            variance = ((count * sumOfSquares) - (sum * sum)) / (count * (count - 1));
        }
        return variance;
    }

    static long count = 9223372036854775807L, maximum = -8041659861104728902L, minimum = -9223372036854775808L, sum = -1092753134824223567L, sumOfSquares = -9223372036854775808L;

    static String variableName = "yl>3(H<$y\\";

    long getStandardDeviation() {
        return (long) java.lang.Math.sqrt(getVariance());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7949().getStandardDeviation());
    }
}
