public class MyJVMTest_9268 {

    static Runnable runWithinGetAttribute = null;

    static int getCount = 0;

    static int thing = 1;

    int getThing() {
        Thread t = new Thread(runWithinGetAttribute);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getCount++;
        return thing;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9268().getThing());
    }
}
