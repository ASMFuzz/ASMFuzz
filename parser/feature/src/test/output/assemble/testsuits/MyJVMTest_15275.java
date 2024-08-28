public class MyJVMTest_15275 {

    static String msg = "X{qV~d'r~S";

    static long startTime = System.nanoTime();

    String log(String msg) {
        final String elapsedSeconds = String.format("%.3fs", (System.nanoTime() - startTime) / 1_000_000_000.0);
        System.out.println("[" + elapsedSeconds + "] (" + Thread.currentThread().getName() + ") " + msg);
        return elapsedSeconds;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15275().log(msg);
    }
}
