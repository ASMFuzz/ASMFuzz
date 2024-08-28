public class MyJVMTest_3497 {

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
        new MyJVMTest_3497().run();
    }
}
