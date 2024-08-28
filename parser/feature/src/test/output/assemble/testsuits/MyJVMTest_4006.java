public class MyJVMTest_4006 {

    static int exitValue = 9;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    String getStdErr() {
        return stderr.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4006().getStdErr());
    }
}
