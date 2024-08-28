public class MyJVMTest_8857 {

    static String text = "[k@g%pum(5";

    static long ref = -9223372036854775808L;

    static long actual = 9223372036854775807L;

    long verify(String text, long ref, long actual) {
        if (ref != actual) {
            System.err.println(text + " " + ref + " != " + actual);
            throw new Error("Fail");
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8857().verify(text, ref, actual);
    }
}
