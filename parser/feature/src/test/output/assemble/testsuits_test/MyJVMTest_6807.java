public class MyJVMTest_6807 {

    static Integer[] a = { -872181337, 0, 0, 0, 9, 0, 9, 7, 3, 0 };

    static int myKey = 1;

    static int myValue = 4;

    static long mySeed = -8227670149403881504L;

    int checkSumXor(Integer[] a) {
        int checkSum = 0;
        for (Integer e : a) {
            checkSum ^= e.intValue();
        }
        return checkSum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6807().checkSumXor(a));
    }
}
