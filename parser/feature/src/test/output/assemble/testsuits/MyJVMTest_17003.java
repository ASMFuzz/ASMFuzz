public class MyJVMTest_17003 {

    static String text = "QzS\"!kTeT5";

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
        new MyJVMTest_17003().verify(text, ref, actual);
    }
}
