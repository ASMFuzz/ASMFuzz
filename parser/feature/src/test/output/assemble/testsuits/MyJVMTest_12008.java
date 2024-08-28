public class MyJVMTest_12008 {

    static int[] a0 = { 1, -1449207679, 2, 9, 0, 9, 0, 3, 0, 4 };

    static int[] a1 = { 9, 2, -79182039, 2, 6, 2, 390153836, 310808963, -1945433604, 0 };

    static int VALUE = 15;

    int[] test_srac_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12008().test_srac_n(a0, a1);
    }
}
