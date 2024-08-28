public class MyJVMTest_11300 {

    static String text = "2]ftqHj]#k";

    static int ref = 8;

    static int actual = -1810209050;

    int verify(String text, int ref, int actual) {
        if (ref != actual) {
            System.err.println(text + " " + ref + " != " + actual);
            throw new Error("Fail");
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11300().verify(text, ref, actual);
    }
}
