public class MyJVMTest_16483 {

    static long lFld = 10;

    static float fFld = 11.2f;

    static int iFld = 12;

    void test() {
        int[] iArr = new int[200];
        float[] fArr = new float[200];
        for (int i = 5; i < 169; i++) {
            fArr[i + 1] += ((long) (fFld) | 1);
            iFld += lFld;
            fArr[i - 1] -= 20;
            fFld += i;
            fArr[i + 1] -= -117;
            int j = 10;
            do {
            } while (--j > 0);
            iArr[i] += 11;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16483().test();
    }
}
