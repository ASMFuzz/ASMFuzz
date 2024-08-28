public class MyJVMTest_6715 {

    static int[] a0 = { 1446644652, -1430559065, 1, 7, 8, -335427372, 0, -62682532, 0, 0 };

    static int[] a1 = { 4, 6, 0, 3, 5, 0, 9, 5, 619737010, 3 };

    static int VALUE = 15;

    int[] test_addc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] + VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6715().test_addc(a0, a1);
    }
}
