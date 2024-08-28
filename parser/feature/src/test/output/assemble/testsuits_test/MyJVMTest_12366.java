public class MyJVMTest_12366 {

    static short[] a = { 32767, 32767, -9714, 0, -32768, -32768, 0, 32767, 32767, -32768 };

    static int OFFSET = 3;

    short[] test_ci_off(short[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12366().test_ci_off(a);
    }
}
