public class MyJVMTest_8928 {

    void noException() {
        Thread.dumpStack();
        throw new RuntimeException("No expected exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8928().noException();
    }
}
