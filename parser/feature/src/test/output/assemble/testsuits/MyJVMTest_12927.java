public class MyJVMTest_12927 {

    static Throwable failed = null;

    static long endtime = 9223372036854775807L;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12927().isComplete());
    }
}
