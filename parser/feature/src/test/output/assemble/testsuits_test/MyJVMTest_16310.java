public class MyJVMTest_16310 {

    static Integer[] a = { 0, 4, -1056659839, 1, 8, 1633709106, 0, 9, 0, 0 };

    static int myKey = 131007739;

    static int myValue = -613088846;

    static long mySeed = 9223372036854775807L;

    int checkSumXor(Integer[] a) {
        int checkSum = 0;
        for (Integer e : a) {
            checkSum ^= e.intValue();
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16310().checkSumXor(a));
    }
}
