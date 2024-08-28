public class MyJVMTest_9446 {

    static long endtime = 0;

    static boolean failed = false;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9446().isComplete());
    }
}
