public class MyJVMTest_14852 {

    static int[] a0 = { 1076046314, 0, 3, 0, 8, -1195799192, -1060650389, -206658607, 3, 7 };

    static int[] a1 = { -753897109, 6, -1265839156, 0, 0, 0, -233337448, 1796305573, 0, 2 };

    static int b = -1319039783;

    int[] test_mulv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14852().test_mulv(a0, a1, b);
    }
}
