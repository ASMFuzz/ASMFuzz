public class MyJVMTest_7387 {

    static int exceptionCount = 0;

    void incrementExceptionCount() {
        exceptionCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7387().incrementExceptionCount();
    }
}
