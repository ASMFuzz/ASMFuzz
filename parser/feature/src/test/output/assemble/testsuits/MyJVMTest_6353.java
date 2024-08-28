public class MyJVMTest_6353 {

    static short[] a = { 24516, 32767, -12715, -32768, 32767, 32767, 32767, -32768, -16174, -32768 };

    static short[] b = { 32767, -32768, 32767, 0, -32768, -32768, 32767, 32767, -1102, -14737 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6353().test_cp_unalnsrc(a, b);
    }
}
