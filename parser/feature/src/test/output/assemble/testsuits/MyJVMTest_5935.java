public class MyJVMTest_5935 {

    static short[] a = { 16940, -32768, -29323, 0, 0, 30463, -32768, 0, -32768, 32767 };

    static short[] b = { 32767, 0, 0, -32768, 0, 13919, -32768, 8522, -32768, 0 };

    short[] test_cp(short[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5935().test_cp(a, b);
    }
}
