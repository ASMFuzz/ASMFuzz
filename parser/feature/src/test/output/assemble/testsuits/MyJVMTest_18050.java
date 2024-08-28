public class MyJVMTest_18050 {

    static long[] a = { -7493551285973825830L, 9223372036854775807L, 9223372036854775807L, -8923274274738454923L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0 };

    static int myKey = 8;

    static int myValue = 3;

    static long mySeed = 8523469734111757055L;

    int checkSumPlus(long[] a) {
        long checkSum = 0;
        for (long e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18050().checkSumPlus(a));
    }
}
