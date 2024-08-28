public class MyJVMTest_17267 {

    static String msg = "PW-V `1RSh";

    static int failures = 0;

    String fail(String msg) {
        failures++;
        System.out.println("FAIL: " + msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17267().fail(msg);
    }
}
