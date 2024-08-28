public class MyJVMTest_18026 {

    static int[] a = { 814429130, 3, -512275133, -184406866, -1660226647, 897625314, 0, 0, -1483812126, 2124674986 };

    static int myKey = -1705248703;

    static int myValue = 8;

    static long mySeed = 9223372036854775807L;

    int checkSumPlus(int[] a) {
        int checkSum = 0;
        for (int e : a) {
            checkSum += e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18026().checkSumPlus(a));
    }
}
