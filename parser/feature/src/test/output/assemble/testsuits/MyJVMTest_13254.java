public class MyJVMTest_13254 {

    static int[] a0 = { 1609791033, -1886643747, 1932016360, 0, -1191693448, 0, -1652698129, -572596881, 0, 0 };

    static int[] a1 = { 6, 3, 6, 737855543, 0, 1466932008, 0, 0, 9, 1 };

    static int VALUE = 15;

    int[] test_srlc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13254().test_srlc_n(a0, a1);
    }
}
