public class MyJVMTest_12474 {

    static int operationCount = 0;

    void operation() {
        operationCount++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12474().operation();
    }
}
