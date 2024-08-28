public class MyJVMTest_7351 {

    static short[] a = { -32768, 18500, 0, 0, 25746, 14923, 0, -32768, -32768, 0 };

    short[] test_ci_oppos(short[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7351().test_ci_oppos(a);
    }
}
