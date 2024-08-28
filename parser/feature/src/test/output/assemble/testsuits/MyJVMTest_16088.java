public class MyJVMTest_16088 {

    static char c = '0';

    static int exitValue = 8;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    char appendToStdErr(char c) {
        stderr.append(c);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16088().appendToStdErr(c);
    }
}
