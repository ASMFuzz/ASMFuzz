public class MyJVMTest_9255 {

    static int iFld = 6;

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
        new MyJVMTest_9255().test();
    }
}
