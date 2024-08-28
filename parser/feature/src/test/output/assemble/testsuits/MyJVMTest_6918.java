public class MyJVMTest_6918 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN };

    static int myKey = 6;

    static int myValue = -1513331693;

    static long mySeed = -9223372036854775808L;

    int checkSumPlus(float[] a) {
        int checkSum = 0;
        for (float e : a) {
            checkSum += (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6918().checkSumPlus(a));
    }
}
