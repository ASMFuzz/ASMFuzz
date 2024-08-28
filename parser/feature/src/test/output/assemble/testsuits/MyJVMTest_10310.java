public class MyJVMTest_10310 {

    static int milliseconds = 7;

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
        new MyJVMTest_10310().sleep(milliseconds);
    }
}
