public class MyJVMTest_1115 {

    static int milliseconds = 2;

    static Object lock = new Object();

    int sleep(int milliseconds) {
        synchronized (lock) {
            try {
                lock.wait(milliseconds);
            } catch (InterruptedException e) {
            }
        }
        return milliseconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1115().sleep(milliseconds);
    }
}
