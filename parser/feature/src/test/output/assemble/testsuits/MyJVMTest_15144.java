public class MyJVMTest_15144 {

    static int[] b = { 0, 5, 0, 2, 7, 0, 0, 0, 0, 4 };

    static int limit = 1985035538;

    static int result = 0;

    static int c = 1;

    int test_rce5(int[] b, int limit) {
        int indx;
        int sum = b[1];
        result = sum;
        for (indx = 0x80000000; indx < limit; ++indx) {
            if (indx > 0x80000000) {
                if (indx - 9 < -9) {
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
        System.out.println(new MyJVMTest_15144().test_rce5(b, limit));
    }
}
