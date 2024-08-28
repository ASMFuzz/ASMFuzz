public class MyJVMTest_11287 {

    static int[] a = { 1, 3, -1976799404, 0, 5, -1326270969, 0, 976749246, 9, 0 };

    long checkSum(int[] a) {
        long sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11287().checkSum(a));
    }
}
