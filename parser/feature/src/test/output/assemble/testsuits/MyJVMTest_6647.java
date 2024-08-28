public class MyJVMTest_6647 {

    static int delay = 0;

    void run() {
        synchronized (this) {
            this.notify();
            try {
                this.wait(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6647().run();
    }
}
