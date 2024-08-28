public class MyJVMTest_1909 {

    static long time = -3421979776724032513L;

    Object doSleep(long time) throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
            lock.wait(time);
        }
        return lock;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1909().doSleep(time);
    }
}
