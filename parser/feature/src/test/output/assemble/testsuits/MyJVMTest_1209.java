public class MyJVMTest_1209 {

    static short[] a = { 32767, -32768, 5776, -32768, 32767, -32768, 32767, 13933, 0, -15474 };

    short[] test_ci(short[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1209().test_ci(a);
    }
}
