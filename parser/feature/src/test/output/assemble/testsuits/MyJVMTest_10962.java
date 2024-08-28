public class MyJVMTest_10962 {

    void generateException() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10962().generateException();
    }
}
