public class MyJVMTest_16845 {

    static byte[] a = { 35, -26, 13, -85, -109, -30, 108, 17, -45, 15 };

    static int myKey = 0;

    static int myValue = 5;

    static long mySeed = 9223372036854775807L;

    int checkSumXor(byte[] a) {
        byte checkSum = 0;
        for (byte e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16845().checkSumXor(a));
    }
}
