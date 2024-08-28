public class MyJVMTest_8440 {

    static int[] a = { 0, 0, 0, 2, 0, -1849708016, 0, 0, -802729819, 0 };

    static int myKey = 6;

    static int myValue = 9;

    static long mySeed = 2411133286941581180L;

    int checkSumPlus(int[] a) {
        int checkSum = 0;
        for (int e : a) {
            checkSum += e;
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8440().checkSumPlus(a));
    }
}
