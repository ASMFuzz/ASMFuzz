public class MyJVMTest_2825 {

    static int[] a0 = { 8, 0, 3, 1, 786524264, -79344599, 7, -68935793, 5, -786655282 };

    static int[] a1 = { 192952293, 0, 2, 4, 7, 9, -226432597, 4, 4, 9 };

    static int SHIFT = 32;

    int[] test_srlc_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2825().test_srlc_on(a0, a1);
    }
}
