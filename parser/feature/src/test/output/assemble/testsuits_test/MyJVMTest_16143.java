public class MyJVMTest_16143 {

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
        new MyJVMTest_16143().run();
    }
}
