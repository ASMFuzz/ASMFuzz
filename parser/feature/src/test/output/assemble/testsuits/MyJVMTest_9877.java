public class MyJVMTest_9877 {

    static boolean state = false;

    static int waiting = 0;

    void raise() {
        state = true;
        if (waiting > 0) {
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9877().raise();
    }
}
