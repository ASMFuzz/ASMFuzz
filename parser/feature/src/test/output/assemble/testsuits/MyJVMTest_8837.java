public class MyJVMTest_8837 {

    static String text = " pCb]h#,TV";

    static int ref = 56031600;

    static int actual = 0;

    int verify(String text, int ref, int actual) {
        if (ref != actual) {
            System.err.println(text + " " + ref + " != " + actual);
            throw new Error("Fail");
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8837().verify(text, ref, actual);
    }
}
