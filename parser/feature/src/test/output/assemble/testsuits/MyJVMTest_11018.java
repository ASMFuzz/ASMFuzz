public class MyJVMTest_11018 {

    static int[] b = { 1655645233, 0, 0, 0, 1, 8, -54355066, 1448285491, 3, -1630584497 };

    static int limit = -145003308;

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
        System.out.println(new MyJVMTest_11018().test_rce6(b, limit));
    }
}
