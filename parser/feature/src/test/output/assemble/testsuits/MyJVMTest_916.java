public class MyJVMTest_916 {

    static long l = -9223372036854775808L;

    static long stop = 0;

    static float res = Float.MAX_VALUE;

    float test_helper(long l, long stop, float res) {
        if (l < stop) {
            res += l;
        } else {
            res *= l;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_916().test_helper(l, stop, res));
    }
}
