public class MyJVMTest_3246 {

    static int exitcode = 683497955;

    int usage(int exitcode) {
        System.err.println("usage: java SerialTest [read|write] <filename>");
        System.exit(exitcode);
        return exitcode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3246().usage(exitcode);
    }
}
