public class MyJVMTest_3791 {

    static double[] a = { 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static int myKey = 6;

    static int myValue = -1482574541;

    static long mySeed = -9223372036854775808L;

    int checkSumPlus(double[] a) {
        int checkSum = 0;
        for (double e : a) {
            checkSum += (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3791().checkSumPlus(a));
    }
}
