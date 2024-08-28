public class MyJVMTest_9182 {

    static String x = ",`ZFgI5,QV";

    static RuntimeException theUncheckedException = new UnsupportedOperationException("The unchecked exception " + "that should be seen");

    String setUncheckedException(String x) {
        throw theUncheckedException;
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9182().setUncheckedException(x);
    }
}
