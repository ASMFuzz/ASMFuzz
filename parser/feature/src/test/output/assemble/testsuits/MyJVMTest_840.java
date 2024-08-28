public class MyJVMTest_840 {

    void throwException() throws IllegalArgumentException, InterruptedException {
        Thread.sleep(10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_840().throwException();
    }
}
