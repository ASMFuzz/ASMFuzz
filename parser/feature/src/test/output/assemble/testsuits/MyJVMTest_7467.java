public class MyJVMTest_7467 {

    static String text = "$!Ee-+p145";

    static long ref = -9223372036854775808L;

    static long actual = -8031833540883277688L;

    long verify(String text, long ref, long actual) {
        if (ref != actual) {
            System.err.println(text + " " + ref + " != " + actual);
            throw new Error("Fail");
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7467().verify(text, ref, actual);
    }
}
