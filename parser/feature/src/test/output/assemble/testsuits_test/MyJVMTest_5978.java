public class MyJVMTest_5978 {

    static String timeOutMsg = "WS<`#$aWD$";

    static long timeout = -3061308140267242837L;

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
        new MyJVMTest_5978().requireClear(timeOutMsg, timeout);
    }
}
