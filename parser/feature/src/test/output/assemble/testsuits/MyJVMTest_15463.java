public class MyJVMTest_15463 {

    static String dummyString = "long long string";

    static boolean pleaseStop = false;

    void run() {
        while (!pleaseStop) {
            synchronized (this) {
                try {
                    wait(1);
                } catch (Exception ex) {
                }
            }
            dummyString = new StringBuilder(dummyString).append(dummyString).toString();
            if (dummyString.length() > 1024 * 1024) {
                dummyString = "long long string";
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15463().run();
    }
}
