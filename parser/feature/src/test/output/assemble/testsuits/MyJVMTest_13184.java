public class MyJVMTest_13184 {

    static char[] a = { Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, '%', Character.MIN_VALUE, '0', '0', 't', '0' };

    static int myKey = 2;

    static int myValue = 9;

    static long mySeed = 7671547556350792895L;

    int checkSumXor(char[] a) {
        char checkSum = 0;
        for (char e : a) {
            checkSum ^= e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13184().checkSumXor(a));
    }
}
