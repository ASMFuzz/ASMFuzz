public class MyJVMTest_10447 {

    static Class<?> k = null;

    static Object x = 1686832857;

    static Object y = 0;

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static boolean debug = Boolean.getBoolean("debug");

    static Object elLoco = 0;

    static long quittingTime = 9223372036854775807L;

    static int i = 0;

    Class<?> describe(Class<?> k, Object x, Object y) {
        if (debug)
            System.out.printf("%s: %s, %s%n", k.getSimpleName(), x.getClass().getSimpleName(), y.getClass().getSimpleName());
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10447().describe(k, x, y);
    }
}
