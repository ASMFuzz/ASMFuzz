public class MyJVMTest_16880 {

    static short[] a = { -17215, -5275, 32767, -32768, -32768, 0, 0, -24824, 20858, -24947 };

    short[] test_ci_oppos(short[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16880().test_ci_oppos(a);
    }
}
