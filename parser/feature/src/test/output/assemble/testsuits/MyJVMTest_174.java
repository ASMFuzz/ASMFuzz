public class MyJVMTest_174 {

    static int[] a0 = { 84855067, 7, 5, 3, 3, 2, -260922555, 5, 1, 1983035108 };

    static int[] a1 = { 0, 4, 1411220032, 1294902399, 2, 0, 6, 0, 0, 1 };

    static int[] a2 = { 8, 0, -249405088, 7, 0, 0, 289044981, 0, 1848395555, 3 };

    int[] test_ora(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] | a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_174().test_ora(a0, a1, a2);
    }
}
