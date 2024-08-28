public class MyJVMTest_17115 {

    static long endtime = -9223372036854775808L;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17115().isComplete());
    }
}
