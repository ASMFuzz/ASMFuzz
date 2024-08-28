public class MyJVMTest_12830 {

    void run() {
        while (true) {
            System.gc();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12830().run();
    }
}
