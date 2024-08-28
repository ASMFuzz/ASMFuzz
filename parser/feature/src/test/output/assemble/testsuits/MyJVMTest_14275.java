public class MyJVMTest_14275 {

    static int bsmCount = 0;

    void resetBsmCallCount() {
        bsmCount = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14275().resetBsmCallCount();
    }
}
