public class MyJVMTest_3314 {

    static Integer[] a = { 0, -2104268219, 5, 7, 5, 6, 3, 0, 0, 1 };

    static int myKey = -1835834990;

    static int myValue = 7;

    static long mySeed = 0;

    int checkSumPlus(Integer[] a) {
        int checkSum = 0;
        for (Integer e : a) {
            checkSum += e.intValue();
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3314().checkSumPlus(a));
    }
}
