public class MyJVMTest_9039 {

    static int[] a = { 7, 0, 2, 0, 0, 310371039, 0, 4, 0, 0 };

    long checkSum(int[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9039().checkSum(a));
    }
}
