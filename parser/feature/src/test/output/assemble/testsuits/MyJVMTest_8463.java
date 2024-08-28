public class MyJVMTest_8463 {

    static long[] a = { 9223372036854775807L, 0, -9223372036854775808L, 3457413317475968788L, 0, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static int myKey = -810503636;

    static int myValue = -1169310825;

    static long mySeed = 8903340926839360278L;

    int checkSumPlus(long[] a) {
        long checkSum = 0;
        for (long e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8463().checkSumPlus(a));
    }
}
