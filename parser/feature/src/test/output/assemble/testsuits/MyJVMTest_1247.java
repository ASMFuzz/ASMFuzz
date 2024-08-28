public class MyJVMTest_1247 {

    static Class<?> k = null;

    static Object x = -1852774889;

    static Object y = 6;

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static boolean debug = Boolean.getBoolean("debug");

    static Object elLoco = 7;

    static long quittingTime = 0;

    static int i = 0;

    Class<?> describe(Class<?> k, Object x, Object y) {
        if (debug)
            System.out.printf("%s: %s, %s%n", k.getSimpleName(), x.getClass().getSimpleName(), y.getClass().getSimpleName());
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1247().describe(k, x, y);
    }
}
