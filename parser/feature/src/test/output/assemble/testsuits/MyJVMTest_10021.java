public class MyJVMTest_10021 {

    static String string = "5kA:kI2:.e";

    static String currentTest = "s+9.VgT$r2";

    static int id = -1;

    String reportError(String string) {
        throw new RuntimeException(currentTest + ": " + string);
        return string;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10021().reportError(string);
    }
}
