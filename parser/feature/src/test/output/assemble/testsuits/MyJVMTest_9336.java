public class MyJVMTest_9336 {

    static short[] a = { -1659, -32768, 0, 32767, -32768, 32767, -32768, 8209, 0, 12617 };

    static short[] b = { 865, 0, 32767, 0, 32767, 20377, -32768, -32768, -32311, -32768 };

    static int SCALE = 2;

    short[] test_cp_scl(short[] a, short[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9336().test_cp_scl(a, b);
    }
}
