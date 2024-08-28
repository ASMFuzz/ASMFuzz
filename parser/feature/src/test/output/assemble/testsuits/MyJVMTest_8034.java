public class MyJVMTest_8034 {

    static Object obj = -286624719;

    static byte b = 8;

    static char c = Character.MIN_VALUE;

    static double d = Double.MAX_VALUE;

    static int i = 8;

    static long j = 9223372036854775807L;

    static short s = -23907;

    String identityToString(Object obj) {
        return obj.toString() + "@" + System.identityHashCode(obj);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8034().identityToString(obj));
    }
}
