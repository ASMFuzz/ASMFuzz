public class MyJVMTest_9536 {

    static String s = "dP_!w825p<";

    long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    static long startTime = currentTimeMillis();

    long log(String s) {
        long time = currentTimeMillis() - startTime;
        long ms = time % 1000;
        time /= 1000;
        long sec = time % 60;
        time /= 60;
        long min = time % 60;
        time /= 60;
        System.out.println("" + (time < 10 ? "0" : "") + time + ":" + (min < 10 ? "0" : "") + min + ":" + (sec < 10 ? "0" : "") + sec + "." + (ms < 10 ? "00" : (ms < 100 ? "0" : "")) + ms + " (" + Thread.currentThread().getName() + ") " + s);
        return time;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9536().log(s);
    }
}
