public class MyJVMTest_294 {

    static long endtime = 8862819449212590613L;

    static boolean failed = true;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0 || failed;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_294().isComplete());
    }
}
