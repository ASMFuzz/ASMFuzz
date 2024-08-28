public class MyJVMTest_13774 {

    static Runnable runWithinGetAttribute = null;

    static int getCount = -2066764585;

    static String thing = "r)?4996\")U";

    String getThing() {
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
        System.out.println(new MyJVMTest_13774().getThing());
    }
}
