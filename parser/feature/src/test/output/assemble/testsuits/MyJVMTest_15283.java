public class MyJVMTest_15283 {

    static int cnt1 = 0;

    void testCallee() {
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 10; ++j) {
                cnt1 += j;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15283().testCallee();
    }
}
