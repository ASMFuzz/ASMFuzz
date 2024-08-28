public class MyJVMTest_15628 {

    static long endtime = 0;

    static Throwable failed = null;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15628().isComplete());
    }
}
