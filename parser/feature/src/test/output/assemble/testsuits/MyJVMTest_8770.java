public class MyJVMTest_8770 {

    static long endtime = 9223372036854775807L;

    boolean isComplete() {
        return endtime - System.nanoTime() < 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8770().isComplete());
    }
}
