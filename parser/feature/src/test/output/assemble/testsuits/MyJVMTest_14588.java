public class MyJVMTest_14588 {

    static int[] a = { 9, 0, 8, 0, 7, 7, -435607077, 0, 0, 0 };

    static int myKey = 3;

    static int myValue = -1346850242;

    static long mySeed = 9223372036854775807L;

    int checkSumXor(int[] a) {
        int checkSum = 0;
        for (int e : a) {
            checkSum ^= e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14588().checkSumXor(a));
    }
}
