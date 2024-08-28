public class MyJVMTest_13938 {

    void noException() {
        Thread.dumpStack();
        throw new RuntimeException("No expected exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13938().noException();
    }
}
