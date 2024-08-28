public class MyJVMTest_16865 {

    static String text = "nw>V=qg36 ";

    static int i = 9;

    static long elem = 9223372036854775807L;

    static long val = 9223372036854775807L;

    int verify(String text, int i, long elem, long val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + Long.toHexString(elem) + " != " + Long.toHexString(val));
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16865().verify(text, i, elem, val));
    }
}
