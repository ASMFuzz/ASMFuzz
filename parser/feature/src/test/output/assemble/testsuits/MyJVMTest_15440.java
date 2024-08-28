public class MyJVMTest_15440 {

    static byte[] a = { -99, 16, 125, -90, 122, 122, 48, -29, 127, -50 };

    static int myKey = 6;

    static int myValue = 284641728;

    static long mySeed = -9223372036854775808L;

    int checkSumPlus(byte[] a) {
        byte checkSum = 0;
        for (byte e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15440().checkSumPlus(a));
    }
}
