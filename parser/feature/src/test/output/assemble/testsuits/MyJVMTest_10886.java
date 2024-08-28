public class MyJVMTest_10886 {

    static int[] a1 = { 4, -1264304122, 549756590, 214086556, 0, 3, 3, 0, 3, 0 };

    static int[] a2 = { 0, 1, 693163757, 4, 5, 440548929, -696461378, 5, 0, 6 };

    static int[] a3 = { -572347975, -1461084512, 0, 182120009, 4, 7, -366067845, -1436725417, 5, 7 };

    int prodInt(int[] a1, int[] a2, int[] a3) {
        int total = 1;
        for (int i = 0; i < a1.length; i++) {
            total *= (a1[i] * a2[i]) + (a1[i] * a3[i]) + (a2[i] * a3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10886().prodInt(a1, a2, a3));
    }
}
