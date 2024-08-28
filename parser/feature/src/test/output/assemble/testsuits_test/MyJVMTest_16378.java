public class MyJVMTest_16378 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, 0.888013214916213, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY };

    static int myKey = 8;

    static int myValue = 0;

    static long mySeed = -9223372036854775808L;

    int checkSumXor(double[] a) {
        int checkSum = 0;
        for (double e : a) {
            checkSum ^= (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16378().checkSumXor(a));
    }
}
