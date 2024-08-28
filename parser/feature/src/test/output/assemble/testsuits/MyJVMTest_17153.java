public class MyJVMTest_17153 {

    static String x = "kFt~+|/);*";

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    String setCheckedException(String x) throws Exception {
        throw theCheckedException;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17153().setCheckedException(x);
    }
}
