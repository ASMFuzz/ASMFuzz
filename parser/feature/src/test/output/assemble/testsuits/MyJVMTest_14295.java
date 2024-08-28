public class MyJVMTest_14295 {

    static short[] a = { -32768, 0, 32767, 30831, 32767, -5517, -32768, 0, -32768, -32768 };

    static short[] b = { 0, 32767, 32767, 32767, 0, 0, -12797, -32768, 32767, -31745 };

    static int OFFSET = 3;

    short[] test_2ci_off(short[] a, short[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
            b[i + OFFSET] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14295().test_2ci_off(a, b);
    }
}
