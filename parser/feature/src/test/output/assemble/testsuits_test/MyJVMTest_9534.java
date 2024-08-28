public class MyJVMTest_9534 {

    static char[] a = { '"', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '(' };

    static int myKey = 0;

    static int myValue = 1;

    static long mySeed = 9223372036854775807L;

    int checkSumPlus(char[] a) {
        char checkSum = 0;
        for (char e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9534().checkSumPlus(a));
    }
}
