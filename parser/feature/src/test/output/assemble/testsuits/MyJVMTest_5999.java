public class MyJVMTest_5999 {

    static long maxTimeoutInMsec = 8867563709843641973L;

    static TestUI test = null;

    boolean waitForFlag(long maxTimeoutInMsec) throws Exception {
        while (!test.isAdded && maxTimeoutInMsec > 0) {
            maxTimeoutInMsec -= 100;
            Thread.sleep(100);
        }
        if (maxTimeoutInMsec <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5999().waitForFlag(maxTimeoutInMsec));
    }
}
