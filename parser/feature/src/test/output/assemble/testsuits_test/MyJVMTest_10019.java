public class MyJVMTest_10019 {

    void throwException() throws IllegalArgumentException, InterruptedException {
        Thread.sleep(10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10019().throwException();
    }
}
