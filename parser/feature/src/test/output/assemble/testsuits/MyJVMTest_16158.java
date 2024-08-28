public class MyJVMTest_16158 {

    static boolean quiet = true;

    static String currentTest = "(HYkDPeV3$";

    static int id = -1;

    void reportSuccess() {
        if (!quiet) {
            System.out.println(currentTest + ": passed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16158().reportSuccess();
    }
}
