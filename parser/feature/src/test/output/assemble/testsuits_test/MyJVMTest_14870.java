public class MyJVMTest_14870 {

    static int exitValue = 495389716;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    String getStdOut() {
        return stdout.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14870().getStdOut());
    }
}
