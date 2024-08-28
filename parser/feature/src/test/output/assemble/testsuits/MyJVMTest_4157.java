public class MyJVMTest_4157 {

    static boolean state = false;

    static int waiting = 0;

    void doWait() throws InterruptedException {
        if (state) {
            return;
        }
        waiting++;
        wait();
        waiting--;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4157().doWait();
    }
}
