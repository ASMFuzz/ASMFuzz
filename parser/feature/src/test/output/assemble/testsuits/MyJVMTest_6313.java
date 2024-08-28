public class MyJVMTest_6313 {

    void doWait() {
        try {
            Thread.sleep(200 * 1000);
        } catch (InterruptedException ie) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6313().doWait();
    }
}
