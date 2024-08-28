public class MyJVMTest_12095 {

    static long[] a = { -8869771154332582385L, 9223372036854775807L, 9223372036854775807L, 0, -6875599727264152395L, 8218485794878356052L, 8004637791009415085L, 0, 0, -8506318318928570487L };

    static long[] b = { 0, 9223372036854775807L, 0, 0, 0, -9223372036854775808L, -9223372036854775808L, 1782655813988464085L, -9223372036854775808L, 909355193932858670L };

    long[] test_cp_oppos(long[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12095().test_cp_oppos(a, b);
    }
}
