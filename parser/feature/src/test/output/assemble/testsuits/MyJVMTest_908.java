public class MyJVMTest_908 {

    static int[] b = { -565012022, 4, 7, 2, 6, 8, 152648062, -2018341828, 0, 0 };

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
        System.out.println(new MyJVMTest_908().test_rce7(b));
    }
}
