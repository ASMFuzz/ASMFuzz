public class MyJVMTest_11820 {

    static short[] a0 = { 0, 32767, 15969, 18382, 32767, 32767, 32767, 848, 32767, -32768 };

    static short[] a1 = { 0, -32768, 0, -32768, 32767, -32768, -5430, 32767, 25817, 0 };

    static int ARRLEN = 1000;

    short[] test_urshift(short[] a0, short[] a1) {
        for (int i = 0; i < ARRLEN; i++) {
            a0[i] = (short) (a1[i] >>> 10);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11820().test_urshift(a0, a1);
    }
}
