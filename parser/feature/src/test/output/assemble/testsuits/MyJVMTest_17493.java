public class MyJVMTest_17493 {

    static long quittingTime = 1268517955351831640L;

    static int i = 0;

    boolean keepGoing() {
        return (i++ % 128 != 0) || (System.nanoTime() - quittingTime < 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17493().keepGoing());
    }
}
