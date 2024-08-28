public class MyJVMTest_122 {

    static Runnable runWithinGetAttribute = null;

    static int getCount = 1428768208;

    static int thing = 2;

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
        System.out.println(new MyJVMTest_122().getThing());
    }
}
