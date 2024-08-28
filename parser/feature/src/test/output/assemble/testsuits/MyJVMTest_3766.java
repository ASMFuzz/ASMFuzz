public class MyJVMTest_3766 {

    static short[] a = { 32767, 10561, 32767, -32768, 32767, 32767, 0, 32767, -32768, 0 };

    static int myKey = 1175398178;

    static int myValue = 9;

    static long mySeed = 0;

    int checkSumPlus(short[] a) {
        short checkSum = 0;
        for (short e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3766().checkSumPlus(a));
    }
}
