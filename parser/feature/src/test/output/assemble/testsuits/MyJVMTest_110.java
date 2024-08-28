public class MyJVMTest_110 {

    static int iFld = 1649351788;

    static int[] iArr = new int[1024];

    void test() {
        int local = 4;
        for (int i = 0; i < 1024; i++) {
            iFld = -85;
            iFld = iFld + local;
            local = local * iArr[i];
            iArr[i] = 3;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_110().test();
    }
}
