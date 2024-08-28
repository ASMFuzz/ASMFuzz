public class MyJVMTest_9037 {

    static long endtime = 4497554816852007551L;

    static boolean failed = true;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9037().isComplete());
    }
}
