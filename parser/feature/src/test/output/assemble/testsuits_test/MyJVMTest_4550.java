public class MyJVMTest_4550 {

    void noException() {
        Thread.dumpStack();
        throw new RuntimeException("No expected exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4550().noException();
    }
}
