public class MyJVMTest_5050 {

    static Object go = new Object();

    static int count = 2096139566;

    void signal() {
        synchronized (go) {
            count--;
            go.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5050().signal();
    }
}
