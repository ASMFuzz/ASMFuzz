public class MyJVMTest_6592 {

    static char c = 'y';

    static int exitValue = 7;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    char appendToStdErr(char c) {
        stderr.append(c);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6592().appendToStdErr(c);
    }
}
