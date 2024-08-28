public class MyJVMTest_11747 {

    void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.gc();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11747().run();
    }
}
