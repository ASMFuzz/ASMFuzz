public class MyJVMTest_15433 {

    static String timeOutMsg = "G=4%_F\\v7y";

    static long timeout = 2940238363459488226L;

    boolean isClear() {
        return clear;
    }

    static boolean clear = false;

    long requireClear(String timeOutMsg, long timeout) throws RuntimeException {
        long endtime = System.currentTimeMillis() + timeout;
        try {
            while (isClear() == false) {
                if (System.currentTimeMillis() < endtime) {
                    wait(200);
                } else {
                    break;
                }
            }
            if (!isClear()) {
                throw new RuntimeException(timeOutMsg);
            }
        } catch (InterruptedException ix) {
        }
        return timeout;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15433().requireClear(timeOutMsg, timeout);
    }
}
