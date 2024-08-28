public class MyJVMTest_4579 {

    static int[] a1 = { 0, 7, 6, 1, 0, 3, 6, 0, 8, 6 };

    static int[] a2 = { 2125935673, -613161904, -122530496, 7, 1, 6, 833963288, 0, 0, 9 };

    static int[] a3 = { 3, -1468600434, -1476399620, 0, 584768884, 4, 7, 6, 0, 2 };

    int sumInt(int[] a1, int[] a2, int[] a3) {
        int total = 0;
        for (int i = 0; i < a1.length; i++) {
            total += (a1[i] * a2[i]) + (a1[i] * a3[i]) + (a2[i] * a3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4579().sumInt(a1, a2, a3));
    }
}
