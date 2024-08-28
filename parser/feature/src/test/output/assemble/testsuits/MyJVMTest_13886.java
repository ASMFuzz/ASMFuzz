public class MyJVMTest_13886 {

    static RuntimeException theUncheckedException = new UnsupportedOperationException("The unchecked exception " + "that should be seen");

    String getUncheckedException() {
        throw theUncheckedException;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13886().getUncheckedException());
    }
}
