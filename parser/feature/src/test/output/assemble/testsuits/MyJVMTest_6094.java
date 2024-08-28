public class MyJVMTest_6094 {

    static RuntimeException theUncheckedException = new UnsupportedOperationException("The unchecked exception " + "that should be seen");

    void UncheckedException() {
        throw theUncheckedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6094().UncheckedException();
    }
}
