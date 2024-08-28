public class MyJVMTest_13127 {

    static int a = 3;

    static byte c = 127;

    long checkSum(long[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13127().checkSum(a));
    }
}
