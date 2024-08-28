public class MyJVMTest_2544 {

    static short[] a0 = { 32767, 29197, 0, -32768, 0, -32768, -5634, 0, 32767, -32768 };

    static short[] a1 = { -32561, 32767, -32768, 0, -32768, 20958, -32768, 0, 0, -32768 };

    static int ARRLEN = 1000;

    short[] test_urshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (a1[i] >>> 10);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2544().test_urshift(a0, a1);
    }
}
