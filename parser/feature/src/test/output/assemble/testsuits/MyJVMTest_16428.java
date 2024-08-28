public class MyJVMTest_16428 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0.8240614f, 0.6582718f };

    static int myKey = 4;

    static int myValue = 0;

    static long mySeed = -9223372036854775808L;

    int checkSumPlus(float[] a) {
        int checkSum = 0;
        for (float e : a) {
            checkSum += (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16428().checkSumPlus(a));
    }
}
