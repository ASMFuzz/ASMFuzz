public class MyJVMTest_16233 {

    static Object go = new Object();

    static int count = 0;

    static int waiters = 0;

    int getWaiterCount() {
        synchronized (go) {
            return waiters;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16233().getWaiterCount());
    }
}
