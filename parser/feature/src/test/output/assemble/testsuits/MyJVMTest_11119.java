public class MyJVMTest_11119 {

    static int[] a0 = { 0, 371683217, 4, 8, 0, 1189944849, 0, 8, 1766830601, 176910025 };

    static int[] a1 = { 3, 0, 0, 0, 0, 7, 9, 7, 8, 3 };

    static int[] a2 = { 6, 0, 8, 0, 8, 0, -548253392, 6, 3, 4 };

    int[] test_anda(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] & a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11119().test_anda(a0, a1, a2);
    }
}
