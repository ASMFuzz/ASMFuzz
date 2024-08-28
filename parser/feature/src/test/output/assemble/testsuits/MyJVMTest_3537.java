public class MyJVMTest_3537 {

    static short[] a0 = { 32767, 0, 32767, -32768, -32768, -12436, -32768, 0, -18722, 32767 };

    static short[] a1 = { 32767, 32767, -32768, 24204, 0, -2417, 5702, -32768, 0, 1471 };

    static int ARRLEN = 1000;

    short[] test_init(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (i & 3);
            a1[i] = (short) i;
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3537().test_init(a0, a1);
    }
}
