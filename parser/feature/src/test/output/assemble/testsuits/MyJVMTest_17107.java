public class MyJVMTest_17107 {

    static short[] a = { 0, 32767, -20826, 32767, 5677, 0, 0, 0, 32767, -32768 };

    static short[] b = { 0, 5795, -139, 0, 0, 32767, 0, 32767, -32768, -32768 };

    static int OFFSET = 3;

    short[] test_cp_off(short[] a, short[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b[i + OFFSET];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17107().test_cp_off(a, b);
    }
}
