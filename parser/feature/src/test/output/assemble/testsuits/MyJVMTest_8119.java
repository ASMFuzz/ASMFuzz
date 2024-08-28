public class MyJVMTest_8119 {

    static String what = "LI2EENiP~G";

    static int failures = 0;

    String failure(String what) {
        System.out.println("FAILED: " + what);
        failures++;
        return what;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8119().failure(what);
    }
}
