public class MyJVMTest_9129 {

    static long l = -9223372036854775808L;

    static long stop = 6047986884481627754L;

    static float res = 0f;

    float test_helper(long l, long stop, float res) {
        if (l < stop) {
            res += l;
        } else {
            res *= l;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9129().test_helper(l, stop, res));
    }
}
