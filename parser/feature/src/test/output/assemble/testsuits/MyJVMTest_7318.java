public class MyJVMTest_7318 {

    static byte[] a = { 9, 16, 33, -60, -57, -93, -35, 44, 97, 29 };

    static int myKey = 1;

    static int myValue = 0;

    static long mySeed = 0;

    int checkSumXor(byte[] a) {
        byte checkSum = 0;
        for (byte e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7318().checkSumXor(a));
    }
}
