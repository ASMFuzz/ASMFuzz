public class MyJVMTest_6827 {

    static short[] a = { -32768, -32768, -32768, 32767, 32767, 32767, -32768, 0, -18939, 32767 };

    static int myKey = 1476597008;

    static int myValue = 0;

    static long mySeed = 3693252455691405291L;

    int checkSumXor(short[] a) {
        short checkSum = 0;
        for (short e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6827().checkSumXor(a));
    }
}
