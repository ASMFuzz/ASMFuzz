public class MyJVMTest_7564 {

    static short[] a = { -32768, 0, 26308, 0, 0, 32767, 0, 32767, 0, 0 };

    static short[] b = { 32767, 32767, -26066, 32767, -21243, -3200, -32768, -32768, 19848, -23665 };

    static int OFFSET = 3;

    short[] test_cp_off(short[] a, short[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7564().test_cp_off(a, b);
    }
}
