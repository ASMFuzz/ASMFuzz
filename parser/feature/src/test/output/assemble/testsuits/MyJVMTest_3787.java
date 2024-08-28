public class MyJVMTest_3787 {

    static int a = 6;

    static byte c = -128;

    long checkSum(long[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3787().checkSum(a));
    }
}
