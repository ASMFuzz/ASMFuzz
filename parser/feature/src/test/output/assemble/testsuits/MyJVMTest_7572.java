public class MyJVMTest_7572 {

    static long endtime = 0;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7572().isComplete());
    }
}
