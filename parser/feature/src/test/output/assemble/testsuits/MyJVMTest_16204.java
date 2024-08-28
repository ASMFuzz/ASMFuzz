public class MyJVMTest_16204 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Integer one = 1;

    static boolean done = false;

    static Object elLoco = -1403756026;

    static long quittingTime = -9223372036854775808L;

    static int i = 0;

    boolean keepGoing(int i) {
        return (i % 128 != 0) || !done;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16204().keepGoing(i));
    }
}
