public class MyJVMTest_13105 {

    static short[] a = { 27723, -32768, 0, -32768, 0, 32767, -21378, -32768, -32768, 0 };

    static int myKey = 1;

    static int myValue = 6;

    static long mySeed = 9223372036854775807L;

    int checkSumPlus(short[] a) {
        short checkSum = 0;
        for (short e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13105().checkSumPlus(a));
    }
}
