public class MyJVMTest_11398 {

    static int[] a0 = { 0, 1772895947, 1408233539, 0, 7, 3, -1468359181, -1631832840, 2, 1 };

    static int[] a1 = { 0, 6, 4, -1588037986, 0, -964428056, 6, 3, 716687707, 2 };

    static int VALUE = 15;

    int[] test_mulc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] * VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11398().test_mulc(a0, a1);
    }
}
