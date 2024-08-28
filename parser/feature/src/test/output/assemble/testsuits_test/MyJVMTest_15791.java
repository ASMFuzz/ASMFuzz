public class MyJVMTest_15791 {

    void doWait() {
        try {
            Thread.sleep(200 * 1000);
        } catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15791().doWait();
    }
}
