public class MyJVMTest_4398 {

    static Runnable runWithinGetAttribute = null;

    static int getCount = 5;

    static String thing = "np+?UpW03'";

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
        System.out.println(new MyJVMTest_4398().getThing());
    }
}
