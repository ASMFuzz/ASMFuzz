public class MyJVMTest_16433 {

    static short[] a = { -32768, 0, 32767, -32768, 32767, -28352, -32768, 32767, -32768, 32767 };

    static short[] b = { -32768, -32768, -32768, -547, -8577, 32767, -20600, 26367, 0, -28417 };

    short[] test_cp_oppos(short[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16433().test_cp_oppos(a, b);
    }
}
