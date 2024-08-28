public class MyJVMTest_1794 {

    static int[] b = { 4, 7, -1756526336, -309029236, 7, 0, 7, 552528726, -1321759198, 2 };

    static int limit = 0;

    static int result = 0;

    static int c = 1;

    int test_rce6(int[] b, int limit) {
        int indx;
        int sum = b[1];
        result = sum;
        for (indx = 0x80000000; indx < limit; ++indx) {
            if (indx > 0x80000000) {
                if (indx < 0) {
                    sum += result;
                    result = sum;
                } else
                    break;
                if (indx * 28 + 1 < 0) {
                    sum += indx;
                    result = sum;
                    sum ^= b[indx & 7];
                    result = sum;
                } else
                    break;
            } else {
                sum += b[indx & 3];
                result = sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1794().test_rce6(b, limit));
    }
}
