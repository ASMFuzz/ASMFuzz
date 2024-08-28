public class MyJVMTest_932 {

    static String text = "2;!z}x9VsJ";

    static int i = 762376833;

    static long elem = 0;

    static long val = 9223372036854775807L;

    int verify(String text, int i, long elem, long val) {
        if (elem != val) {
            System.err.println(text + "[" + i + "] = " + elem + " != " + val);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_932().verify(text, i, elem, val));
    }
}
