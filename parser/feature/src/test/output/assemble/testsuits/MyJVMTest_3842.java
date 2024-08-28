public class MyJVMTest_3842 {

    static char[] a = { '0', '0', '0', 'f', '0', Character.MAX_VALUE, ',', '0', '%', Character.MAX_VALUE };

    static int myKey = 3;

    static int myValue = 0;

    static long mySeed = 0;

    int checkSumXor(char[] a) {
        char checkSum = 0;
        for (char e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3842().checkSumXor(a));
    }
}
