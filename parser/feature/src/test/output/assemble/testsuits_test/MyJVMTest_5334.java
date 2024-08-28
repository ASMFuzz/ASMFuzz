public class MyJVMTest_5334 {

    static int N = 400;

    static byte byFld = 83;

    void lMeth() {
        int[][] iArr1 = new int[N][N];
        byte[][] byArr = new byte[N][N];
        int i10 = 1;
        do {
            int i11 = 1;
            do {
                iArr1[i10 - 1][i11] = TestPeelingNeverEnteredLoop.byFld;
                byArr[i10][i11] -= (byte) -20046;
                for (int i12 = 1; 1 > i12; ++i12) {
                }
            } while (++i11 < 8);
        } while (++i10 < 212);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5334().lMeth();
    }
}
