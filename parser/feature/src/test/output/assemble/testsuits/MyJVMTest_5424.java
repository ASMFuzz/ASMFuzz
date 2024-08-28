public class MyJVMTest_5424 {

    static int[] a0 = { 7, 8, 0, -126630979, 593874370, 6, 1802597111, 1, 0, 5 };

    static int[] a1 = { 0, -436670534, -620698044, 4, 1, 0, 0, 0, 0, 0 };

    static int b = 3;

    int[] test_mulv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5424().test_mulv(a0, a1, b);
    }
}
