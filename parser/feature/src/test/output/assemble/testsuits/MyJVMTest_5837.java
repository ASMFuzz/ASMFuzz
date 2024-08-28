public class MyJVMTest_5837 {

    static int cnt1 = 0;

    void testCallee() {
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 10; ++j) {
                cnt1 += j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5837().testCallee();
    }
}
