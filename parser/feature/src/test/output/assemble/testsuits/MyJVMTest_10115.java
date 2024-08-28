public class MyJVMTest_10115 {

    static String text = "L2m-|DOEWM";

    static int i = 0;

    static long elem = 9223372036854775807L;

    static long val = 0;

    int verify(String text, int i, long elem, long val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10115().verify(text, i, elem, val));
    }
}
