public class MyJVMTest_13359 {

    static int exitValue = 5;

    static StringBuilder stdout = null;

    static StringBuilder stderr = null;

    String getStdErr() {
        return stderr.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13359().getStdErr());
    }
}
