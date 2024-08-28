public class MyJVMTest_6768 {

    void testCallee() {
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 10; ++j) {
                cnt1 += j;
            }
        }
    }

    static int cnt1 = 0;

    static int cnt2 = 0;

    void test() {
        for (int i = 0; i < 10_000; ++i) {
            testCallee();
            cnt2 = 0;
            for (int j = 0; j < 10; ++j) {
                cnt2 = cnt1 + j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6768().test();
    }
}
