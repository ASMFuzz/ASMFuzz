public class MyJVMTest_6870 {

    static double[] a = { 0d, Double.NaN, 0d, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.7482317064838185 };

    static int myKey = -1994728707;

    static int myValue = 3;

    static long mySeed = -2020044206207998053L;

    int checkSumXor(double[] a) {
        int checkSum = 0;
        for (double e : a) {
            checkSum ^= (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6870().checkSumXor(a));
    }
}
