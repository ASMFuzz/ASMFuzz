public class MyJVMTest_14905 {

    static short[] a = { -32768, 32767, -32768, 32767, 22778, -30659, 32767, 32767, 0, 0 };

    static short[] b = { -32768, 32767, 32767, 0, 32767, -32768, 32767, 32767, 0, -9697 };

    short[] test_2ci(short[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14905().test_2ci(a, b);
    }
}
