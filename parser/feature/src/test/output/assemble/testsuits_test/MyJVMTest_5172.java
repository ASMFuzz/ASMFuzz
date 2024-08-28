public class MyJVMTest_5172 {

    static int[] a = { -1885528080, 6, 0, 3, 3, 3, 7, 0, 0, 0 };

    static int myKey = 8;

    static int myValue = -1148326733;

    static long mySeed = -9223372036854775808L;

    int checkSumXor(int[] a) {
        int checkSum = 0;
        for (int e : a) {
            checkSum ^= e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5172().checkSumXor(a));
    }
}
