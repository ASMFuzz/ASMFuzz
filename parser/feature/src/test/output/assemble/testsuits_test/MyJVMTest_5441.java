public class MyJVMTest_5441 {

    static int exitValue = 3;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    String getStdOut() {
        return stdout.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5441().getStdOut());
    }
}
