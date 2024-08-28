public class MyJVMTest_6708 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Integer one = 1;

    static boolean done = false;

    static Object elLoco = 0;

    static long quittingTime = 9223372036854775807L;

    static int i = 0;

    boolean keepGoing(int i) {
        return (i % 128 != 0) || !done;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6708().keepGoing(i));
    }
}
