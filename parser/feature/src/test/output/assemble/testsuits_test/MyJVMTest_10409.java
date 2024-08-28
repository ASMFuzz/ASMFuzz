public class MyJVMTest_10409 {

    static short[] a = { 0, 3286, 27677, 0, 0, -16298, 3975, 32767, -32768, -32768 };

    short[] test_ci(short[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10409().test_ci(a);
    }
}
