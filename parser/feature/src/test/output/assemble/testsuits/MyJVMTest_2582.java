public class MyJVMTest_2582 {

    static int timeout = -1647226215;

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
        new MyJVMTest_2582().doWait(timeout);
    }
}
