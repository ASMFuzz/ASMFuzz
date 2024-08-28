public class MyJVMTest_6923 {

    static short[] a = { -2813, 23164, 0, -32768, 32767, -32768, 32767, 0, 32767, -20044 };

    static short[] b = { 32767, -32768, 0, 0, 32767, -11741, 0, 32767, -32768, -32768 };

    short[] test_cp_oppos(short[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6923().test_cp_oppos(a, b);
    }
}
