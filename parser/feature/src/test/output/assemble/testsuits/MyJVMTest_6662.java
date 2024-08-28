public class MyJVMTest_6662 {

    static boolean quiet = true;

    static String currentTest = "}P{Lc8ojqb";

    static int id = -1;

    void reportSuccess() {
        if (!quiet) {
            System.out.println(currentTest + ": passed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6662().reportSuccess();
    }
}
