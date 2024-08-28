public class MyJVMTest_1739 {

    void generateException() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1739().generateException();
    }
}
