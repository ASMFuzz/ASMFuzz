public class MyJVMTest_7662 {

    static float[] a = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.MAX_VALUE };

    static int myKey = 402476109;

    static int myValue = 1177999311;

    static long mySeed = 2209447296095437822L;

    int checkSumXor(float[] a) {
        int checkSum = 0;
        for (float e : a) {
            checkSum ^= (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7662().checkSumXor(a));
    }
}
