public class MyJVMTest_5886 {

    static int[] a = { -967778766, 8, 3, -1266474187, 1532106364, 3, 0, 0, 0, 7 };

    static int[] b = { 7, 0, 0, -719967567, 3, 3, 3, 1996864881, -2055901745, 1 };

    static int[] c = { -247297181, 9, 6, 9, 909525922, 0, 4, 183778571, 719105933, -1316546930 };

    int[] reductionInit1(int[] a, int[] b, int[] c) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (i % 2) + 0x4099;
            b[i] = (i % 2) + 0x1033;
            c[i] = (i % 2) + 0x455;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5886().reductionInit1(a, b, c);
    }
}
