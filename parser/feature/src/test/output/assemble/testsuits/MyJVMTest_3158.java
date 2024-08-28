public class MyJVMTest_3158 {

    static int operationCount = 1;

    void operation() {
        operationCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3158().operation();
    }
}
