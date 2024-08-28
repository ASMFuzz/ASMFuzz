public class MyJVMTest_3592 {

    static Throwable failed = null;

    static long endtime = 8697368640079017315L;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3592().isComplete());
    }
}
