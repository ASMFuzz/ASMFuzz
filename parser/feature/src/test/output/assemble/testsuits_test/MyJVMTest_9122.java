public class MyJVMTest_9122 {

    static long endtime = -9223372036854775808L;

    static Throwable failed = null;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9122().isComplete());
    }
}
