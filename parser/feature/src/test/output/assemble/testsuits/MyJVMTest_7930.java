public class MyJVMTest_7930 {

    static long quittingTime = 0;

    static int i = 0;

    boolean keepGoing() {
        return (i++ % 128 != 0) || (System.nanoTime() - quittingTime < 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7930().keepGoing());
    }
}
