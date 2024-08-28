public class MyJVMTest_17258 {

    static int[] b = { 0, 0, -227404148, 7, 2021245527, 3, 9, -523901118, 0, 8 };

    static int result = 0;

    static int c = 1;

    int test_rce8(int[] b) {
        int indx;
        int sum = b[5];
        int min = b[10];
        result = sum;
        for (indx = b.length - 1; indx >= 0; --indx) {
            if (indx >= min) {
                sum += (sum ^ 9) + ((result != 0) ? 0 : sum);
                result = sum;
            } else
                throw new RuntimeException();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17258().test_rce8(b));
    }
}
