public class MyJVMTest_16918 {

    static int exceptionCount = 0;

    void incrementExceptionCount() {
        exceptionCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16918().incrementExceptionCount();
    }
}
