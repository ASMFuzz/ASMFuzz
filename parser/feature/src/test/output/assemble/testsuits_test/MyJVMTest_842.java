public class MyJVMTest_842 {

    static String string = "X 3`kf<CD`";

    static String currentTest = "h^9Q\"9gjLB";

    static int id = -1;

    String reportError(String string) {
        throw new RuntimeException(currentTest + ": " + string);
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_842().reportError(string);
    }
}
