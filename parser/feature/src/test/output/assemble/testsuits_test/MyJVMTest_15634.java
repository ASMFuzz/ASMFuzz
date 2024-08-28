public class MyJVMTest_15634 {

    static byte b = 127;

    static char c = 'K';

    static double d = Double.MAX_VALUE;

    static float f = Float.MIN_VALUE;

    static int i = 0;

    static long j = 9223372036854775807L;

    static String l1 = "@TJkWU/j~W";

    static Class<?> l2 = null;

    static short s = 32767;

    static boolean z = false;

    void reset() {
        b = 1;
        c = '1';
        d = 1.0;
        f = 1.0f;
        i = 1;
        j = 1L;
        l1 = "1";
        l2 = String.class;
        s = 1;
        z = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15634().reset();
    }
}
