public class MyJVMTest_5570 {

    static short[] a = { -31224, 32767, 32767, 25978, -32768, -32768, 21910, 0, -32768, 32767 };

    static short b = 16624;

    short[] test_vi_neg(short[] a, short b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5570().test_vi_neg(a, b);
    }
}
