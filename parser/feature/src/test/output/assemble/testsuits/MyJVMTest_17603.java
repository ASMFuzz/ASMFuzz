public class MyJVMTest_17603 {

    static Object obj = 6;

    static byte b = 127;

    static char c = '0';

    static double d = Double.NEGATIVE_INFINITY;

    static int i = -997994751;

    static long j = 0;

    static short s = -32768;

    String identityToString(Object obj) {
        return obj.toString() + "@" + System.identityHashCode(obj);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17603().identityToString(obj));
    }
}
