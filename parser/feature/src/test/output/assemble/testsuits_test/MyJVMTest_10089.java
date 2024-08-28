public class MyJVMTest_10089 {

    static int[] b = { 0, 1579451439, 0, 0, 0, 0, 8, 0, 1566298674, 0 };

    static int result = 0;

    static int c = 1;

    int test_rce7(int[] b) {
        int indx;
        int max = b[9];
        int sum = b[7];
        result = sum;
        for (indx = 0; indx < b.length; ++indx) {
            if (indx <= max) {
                sum += (indx ^ 15) + ((result != 0) ? 0 : sum);
                result = sum;
            } else
                throw new RuntimeException();
        }
        for (indx = -7; indx < b.length; ++indx) {
            if (indx <= 9) {
                sum += (sum ^ 15) + ((result != 0) ? 0 : sum);
                result = sum;
            } else
                throw new RuntimeException();
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10089().test_rce7(b));
    }
}
