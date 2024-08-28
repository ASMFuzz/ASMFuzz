public class MyJVMTest_12948 {

    static long[] a = { 1460480197148677765L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -6039539833903228539L, -9223372036854775808L, 0, 0, 9223372036854775807L };

    static int myKey = 6;

    static int myValue = 5;

    static long mySeed = 0;

    int checkSumXor(long[] a) {
        long checkSum = 0;
        for (long e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12948().checkSumXor(a));
    }
}
