public class MyJVMTest_2054 {

    static String text = "^2}h ACCVn";

    static int ref = 0;

    static int actual = 1;

    int verify(String text, int ref, int actual) {
        if (ref != actual) {
            System.err.println(text + " " + ref + " != " + actual);
            throw new Error("Fail");
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2054().verify(text, ref, actual);
    }
}
