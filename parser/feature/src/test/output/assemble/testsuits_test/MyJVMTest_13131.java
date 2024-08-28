public class MyJVMTest_13131 {

    static double[] a = { 0d, 0.11197882156813543, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE };

    static int myKey = 9;

    static int myValue = 0;

    static long mySeed = 0;

    int checkSumPlus(double[] a) {
        int checkSum = 0;
        for (double e : a) {
            checkSum += (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13131().checkSumPlus(a));
    }
}
