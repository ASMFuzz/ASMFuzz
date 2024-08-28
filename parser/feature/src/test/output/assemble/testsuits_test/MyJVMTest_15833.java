public class MyJVMTest_15833 {

    static short[] a = { 0, -437, -12921, -23755, -32768, 31529, -32768, -32768, 32767, -20909 };

    static short[] b = { -32768, 0, -32768, 32767, -32768, 0, -32768, 8500, 20558, -32768 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15833().test_cp_unalnsrc(a, b);
    }
}
