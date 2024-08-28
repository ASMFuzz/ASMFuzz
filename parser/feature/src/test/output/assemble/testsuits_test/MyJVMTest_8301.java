public class MyJVMTest_8301 {

    static short[] a = { 0, -21047, 25413, 29984, 32767, 32767, 32767, -10152, 0, 0 };

    static short[] b = { -32768, 32767, -26370, 0, -32768, 0, -32768, 0, 32767, -17086 };

    static short c = -7692;

    static short d = 32767;

    int test_2vi_oppos(short[] a, short[] b, short c, short d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8301().test_2vi_oppos(a, b, c, d);
    }
}
