public class MyJVMTest_6385 {

    static Exception theCheckedException = new Exception("The checked exception that should be seen");

    void CheckedException() throws Exception {
        throw theCheckedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6385().CheckedException();
    }
}
