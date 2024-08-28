public class MyJVMTest_13766 {

    static Object go = new Object();

    static int count = 2;

    static int waiters = 0;

    void await() {
        synchronized (go) {
            waiters++;
            while (count > 0) {
                try {
                    go.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new InternalError();
                }
            }
            waiters--;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13766().await();
    }
}
