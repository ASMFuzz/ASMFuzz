public class MyJVMTest_5121 {

    static int[] a0 = { 0, 0, -2059221019, 0, -1008300403, 8, 1952864933, 2, 3, 8 };

    static int[] a1 = { 1463075679, 8, -516479913, 668442573, 0, 0, 8, 9, 3, 0 };

    static int VALUE = 15;

    int[] test_sllc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5121().test_sllc(a0, a1);
    }
}
