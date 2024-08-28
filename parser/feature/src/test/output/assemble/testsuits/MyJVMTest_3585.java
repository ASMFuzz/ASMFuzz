public class MyJVMTest_3585 {

    static char c = Character.MAX_VALUE;

    static int exitValue = 5;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    char appendToStdOut(char c) {
        stdout.append(c);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3585().appendToStdOut(c);
    }
}
