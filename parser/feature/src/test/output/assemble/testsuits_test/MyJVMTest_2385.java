public class MyJVMTest_2385 {

    static Object sink = -264881363;

    static short sFld = -19206;

    void doTest() {
        int[] arr = new int[400];
        for (int i1 = 0; i1 < 200; i1++) {
            for (int i2 = 0; i2 < 100; i2++) {
                sink = new int[400];
            }
            arr[i1] = 0;
        }
        float f1 = 0;
        for (int i3 = 0; i3 < 200; i3++) {
            f1 += i3 * i3;
        }
        for (int i4 = 0; i4 < 200; i4++) {
            f1 += i4 - sFld;
        }
        System.out.println(arr);
        System.out.println(f1);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2385().doTest();
    }
}
