public class MyJVMTest_2376 {

    static short[] a0 = { 32767, 20665, 1206, -32768, -32768, -32768, 27624, -32768, 32767, -14869 };

    static short[] a1 = { 0, -32196, 32767, 0, 32767, 32767, 0, -32768, 32767, -32768 };

    short[] test_addi(short[] a0, short[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (short) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2376().test_addi(a0, a1);
    }
}
