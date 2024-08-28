public class MyJVMTest_1664 {

    static int[] a1 = { 0, 7, 252674674, 3, -1336091289, 7, 6, 0, 4, 2 };

    static int[] a2 = { 7, -543131078, 4, 2, 8, -1245669106, 5, 0, 4, 0 };

    static int[] a3 = { 5, 614857192, 292269446, 1, 139798632, -443500784, 9, 8, 9, 5 };

    int prodInt(int[] a1, int[] a2, int[] a3) {
        int total = 1;
        for (int i = 0; i < a1.length; i++) {
            total *= (a1[i] * a2[i]) + (a1[i] * a3[i]) + (a2[i] * a3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1664().prodInt(a1, a2, a3));
    }
}
