public class MyJVMTest_3613 {

    static long[] a = { -727735058439985953L, -9223372036854775808L, 0, 0, -1278801150128468665L, 1383079831726641433L, 4504007427513368866L, 0, -9223372036854775808L, -9223372036854775808L };

    static int myKey = 4;

    static int myValue = 5;

    static long mySeed = 9223372036854775807L;

    int checkSumXor(long[] a) {
        long checkSum = 0;
        for (long e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3613().checkSumXor(a));
    }
}
