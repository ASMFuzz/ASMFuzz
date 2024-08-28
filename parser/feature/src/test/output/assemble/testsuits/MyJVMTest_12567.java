public class MyJVMTest_12567 {

    static int exitcode = 0;

    int usage(int exitcode) {
        System.err.println("usage: java SerialTest [read|write] <filename>");
        System.exit(exitcode);
        return exitcode;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12567().usage(exitcode);
    }
}
