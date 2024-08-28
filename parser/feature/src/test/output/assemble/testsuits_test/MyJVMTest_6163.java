public class MyJVMTest_6163 {

    static byte b = 0;

    static char c = Character.MAX_VALUE;

    static double d = Double.NEGATIVE_INFINITY;

    static float f = Float.NEGATIVE_INFINITY;

    static int i = 0;

    static long j = 9223372036854775807L;

    static String l1 = "-GfloYm|X0";

    static Class<?> l2 = null;

    static short s = -31359;

    static boolean z = true;

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
        new MyJVMTest_6163().reset();
    }
}
