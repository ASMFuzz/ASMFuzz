public class MyJVMTest_16331 {

    static short[] a = { -32768, 16379, 32767, 2688, 32767, 32767, 32767, 32767, -32768, -32768 };

    static int myKey = 0;

    static int myValue = 9;

    static long mySeed = 9223372036854775807L;

    int checkSumXor(short[] a) {
        short checkSum = 0;
        for (short e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16331().checkSumXor(a));
    }
}
