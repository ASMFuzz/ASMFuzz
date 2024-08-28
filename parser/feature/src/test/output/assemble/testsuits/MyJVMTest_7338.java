public class MyJVMTest_7338 {

    static String text = "|sA0R9+{A\"";

    static int i = 1365770050;

    static long elem = 0;

    static long val = 9223372036854775807L;

    int verify(String text, int i, long elem, long val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + Long.toHexString(elem) + " != " + Long.toHexString(val));
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7338().verify(text, i, elem, val));
    }
}
