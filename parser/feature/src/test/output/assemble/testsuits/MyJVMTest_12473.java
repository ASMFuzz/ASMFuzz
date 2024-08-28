public class MyJVMTest_12473 {

    static StringBuffer sb = null;

    StringBuffer doWith(StringBuffer sb) {
        "AA".contentEquals(sb);
        return sb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12473().doWith(sb);
    }
}
