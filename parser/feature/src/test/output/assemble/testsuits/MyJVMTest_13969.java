public class MyJVMTest_13969 {

    static int[] a1 = { 9, 4, 6, 0, 0, 5, 1, 8, 942649460, 0 };

    static int[] a2 = { 2, 1804655820, 7, -684440256, 1, 9, -622354196, 2, 0, 8 };

    static int[] a3 = { 0, 6, 0, -626683815, 1916721650, 5, 0, 2, 4, 0 };

    int sumInt(int[] a1, int[] a2, int[] a3) {
        int total = 0;
        for (int i = 0; i < a1.length; i++) {
            total += (a1[i] * a2[i]) + (a1[i] * a3[i]) + (a2[i] * a3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13969().sumInt(a1, a2, a3));
    }
}
