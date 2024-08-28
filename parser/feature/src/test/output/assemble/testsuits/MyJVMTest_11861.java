public class MyJVMTest_11861 {

    static int timeout = 0;

    static boolean state = false;

    static int waiting = 0;

    int doWait(int timeout) throws InterruptedException {
        if (state) {
            return;
        }
        waiting++;
        wait(timeout);
        waiting--;
        return timeout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11861().doWait(timeout);
    }
}
