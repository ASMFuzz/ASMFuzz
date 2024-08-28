public class MyJVMTest_8720 {

    static long start = -9223372036854775808L;

    static long stop = 9223372036854775807L;

    float test_helper(long l, long stop, float res) {
        if (l < stop) {
            res += l;
        } else {
            res *= l;
        }
        return res;
    }

    boolean shouldStop(long l, long stop) {
        return l >= stop;
    }

    float test(long start, long stop) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            }
        }
        float res = 1;
        long l = start;
        for (; ; ) {
            res = test_helper(l, stop, res);
            if (shouldStop(l, stop)) {
                break;
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8720().test(start, stop));
    }
}
