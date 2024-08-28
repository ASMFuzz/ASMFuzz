public class MyJVMTest_5985 {

    static byte[] a = { -19, -21, -56, -87, -91, 107, -66, -13, -24, 113 };

    static int myKey = 1;

    static int myValue = 0;

    static long mySeed = -9223372036854775808L;

    int checkSumPlus(byte[] a) {
        byte checkSum = 0;
        for (byte e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5985().checkSumPlus(a));
    }
}
