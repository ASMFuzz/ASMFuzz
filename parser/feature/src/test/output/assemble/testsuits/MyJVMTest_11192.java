public class MyJVMTest_11192 {

    static short[] a = { 32767, -32768, 20822, 32767, -6226, 32767, 0, -32768, 0, -32768 };

    static int[] b = { 0, 0, 1115453617, 7, -1487933796, 1724340921, 0, 0, 1, 3 };

    static short c = 2015;

    static int d = 6;

    short[] test_vi_oppos(short[] a, int[] b, short c, int d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11192().test_vi_oppos(a, b, c, d);
    }
}
