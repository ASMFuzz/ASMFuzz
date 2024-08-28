public class MyJVMTest_14558 {

    static int[] a0 = { 2, 2, 4, 8, -84849644, 0, 8, 0, 0, -763639439 };

    static int[] a1 = { 0, 6, 0, 111967301, 3, -2096404127, -32422533, 9, 4, 766367823 };

    static int VALUE = 15;

    int[] test_sllc_n(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] << (-VALUE));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14558().test_sllc_n(a0, a1);
    }
}
