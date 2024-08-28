public class MyJVMTest_10405 {

    static boolean condition = false;

    void mainTest() {
        int a = 1, b = 1, c = 1, d = 51;
        for (b = 0; b < 100; b++) {
            a = a + b * 342;
            for (c = 0; c < 100; c++) {
                for (d = 0; d < 1; d++) a = d;
                if (condition)
                    break;
            }
            a = d * a;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10405().mainTest();
    }
}
