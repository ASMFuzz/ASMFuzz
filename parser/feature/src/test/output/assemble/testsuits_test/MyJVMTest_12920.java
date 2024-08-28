public class MyJVMTest_12920 {

    static char c = 'a';

    static int exitValue = 8;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    char appendToStdOut(char c) {
        stdout.append(c);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12920().appendToStdOut(c);
    }
}
