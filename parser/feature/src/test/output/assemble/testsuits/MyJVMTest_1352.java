public class MyJVMTest_1352 {

    static String msg = "lPlt&kb|%P";

    static int errors = -461795069;

    static String internalSource = "public class #O {public class #I {} }";

    String error(String msg) {
        System.err.println(msg);
        errors++;
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1352().error(msg);
    }
}
