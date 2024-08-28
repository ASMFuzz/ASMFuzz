public class MyJVMTest_377 {

    static char[] a = { Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'a', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    static int myKey = 0;

    static int myValue = 1106403211;

    static long mySeed = 3079449806776182837L;

    int checkSumPlus(char[] a) {
        char checkSum = 0;
        for (char e : a) {
            checkSum += e;
        }
        return (int) checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_377().checkSumPlus(a));
    }
}
