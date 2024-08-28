public class MyJVMTest_6736 {

    static Object go = new Object();

    static int count = 2;

    static int waiters = 0;

    int getWaiterCount() {
        synchronized (go) {
            return waiters;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6736().getWaiterCount());
    }
}
