public class MyJVMTest_5386 {

    static int[] a = { 0, 1273682585, 889281955, 0, 0, 0, 1370094235, 1702556175, 9, 9 };

    static int[] b = { 9, 7, 0, 9, 3, 0, 0, 0, 1447782936, 613539876 };

    static int ALIGN_OFF = 8;

    int[] test_cp_alnsrc(int[] a, int[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5386().test_cp_alnsrc(a, b);
    }
}
