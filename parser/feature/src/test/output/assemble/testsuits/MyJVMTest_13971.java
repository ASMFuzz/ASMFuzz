public class MyJVMTest_13971 {

    static short[] a = { -32768, 32767, 0, 10366, 32767, 0, 0, 0, 2591, 0 };

    static short[] b = { 32767, 0, 15499, -32768, 0, 32767, 0, 32035, -32768, 32767 };

    short[] test_2ci_oppos(short[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13971().test_2ci_oppos(a, b);
    }
}
