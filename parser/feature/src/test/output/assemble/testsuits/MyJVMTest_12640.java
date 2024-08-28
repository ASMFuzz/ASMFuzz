public class MyJVMTest_12640 {

    static Integer[] a = { 0, 4, 7, -735829190, 449316187, 0, 0, -1473099223, 1, 3 };

    static int myKey = -2066379222;

    static int myValue = 0;

    static long mySeed = 9223372036854775807L;

    int checkSumPlus(Integer[] a) {
        int checkSum = 0;
        for (Integer e : a) {
            checkSum += e.intValue();
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12640().checkSumPlus(a));
    }
}
