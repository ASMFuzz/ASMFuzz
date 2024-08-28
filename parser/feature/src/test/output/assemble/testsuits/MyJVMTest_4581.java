public class MyJVMTest_4581 {

    static short[] a = { 32767, -21204, -32768, 32767, -23302, 0, 32767, -32768, -15698, 32767 };

    static short[] b = { 32767, 25470, -7128, -32768, -32768, 0, -12874, 0, -32768, -32768 };

    short[] test_2ci_oppos(short[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4581().test_2ci_oppos(a, b);
    }
}
