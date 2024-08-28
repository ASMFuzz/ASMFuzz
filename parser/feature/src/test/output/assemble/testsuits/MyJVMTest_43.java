public class MyJVMTest_43 {

    static String x = "2qa>%$}WFU";

    static RuntimeException theUncheckedException = new UnsupportedOperationException("The unchecked exception " + "that should be seen");

    String setUncheckedException(String x) {
        throw theUncheckedException;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_43().setUncheckedException(x);
    }
}
