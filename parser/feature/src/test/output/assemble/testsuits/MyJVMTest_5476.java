public class MyJVMTest_5476 {

    static short[] a = { 32767, 0, -32768, -27609, 32767, 0, 0, -31975, -32768, 32767 };

    static short[] b = { 32767, -32768, -28601, -32768, 32767, 17785, 0, 32767, 40, -32768 };

    short[] test_2ci(short[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5476().test_2ci(a, b);
    }
}
