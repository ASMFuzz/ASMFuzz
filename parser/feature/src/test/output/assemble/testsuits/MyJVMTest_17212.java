public class MyJVMTest_17212 {

    static float[] a = { 0f, Float.MAX_VALUE, 0.88472706f, 0f, Float.MAX_VALUE, Float.MAX_VALUE, 0f, 0.34498757f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static int myKey = 8;

    static int myValue = 0;

    static long mySeed = 0;

    int checkSumXor(float[] a) {
        int checkSum = 0;
        for (float e : a) {
            checkSum ^= (int) e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17212().checkSumXor(a));
    }
}
