public class MyJVMTest_15387 {

    static short[] a = { -32768, 32767, -32768, 0, 32767, 3428, 32767, 32767, 0, 0 };

    static short[] b = { 2405, 19518, 32767, -32768, 0, 32767, -32768, 0, -27474, 0 };

    short[] test_cp(short[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15387().test_cp(a, b);
    }
}
