public class MyJVMTest_2042 {

    static int[] a = { 0, 8, 1013494013, 4, 6, 5, -1042487177, 9, 2, -1397835764 };

    long checkSum(int[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2042().checkSum(a));
    }
}
