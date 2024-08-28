public class MyJVMTest_5829 {

    static String msg = "Yx}LgyF(ng";

    static long startTime = System.nanoTime();

    String log(String msg) {
        final String elapsedSeconds = String.format("%.3fs", (System.nanoTime() - startTime) / 1_000_000_000.0);
        System.out.println("[" + elapsedSeconds + "] (" + Thread.currentThread().getName() + ") " + msg);
        return elapsedSeconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5829().log(msg);
    }
}
