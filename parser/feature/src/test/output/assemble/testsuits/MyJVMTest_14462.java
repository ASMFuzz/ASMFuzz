public class MyJVMTest_14462 {

    static Object go = new Object();

    static int count = 3;

    void signal() {
        synchronized (go) {
            count--;
            go.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14462().signal();
    }
}
