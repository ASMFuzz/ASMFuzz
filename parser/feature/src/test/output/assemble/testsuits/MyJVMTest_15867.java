public class MyJVMTest_15867 {

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    void CheckedException() throws Exception {
        throw theCheckedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15867().CheckedException();
    }
}
