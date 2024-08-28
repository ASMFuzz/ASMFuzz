public class MyJVMTest_2479 {

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
        new MyJVMTest_2479().run();
    }
}
