public class MyJVMTest_388 {

    static int[] a0 = { 0, 0, 7, 4, 0, 0, -1353617162, 9, 407187191, 9 };

    static int[] a1 = { 982143790, 0, 0, 1746265621, 0, 0, 9, 914931894, 1, 4 };

    static int VALUE = 15;

    int[] test_divc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] / VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_388().test_divc(a0, a1);
    }
}
