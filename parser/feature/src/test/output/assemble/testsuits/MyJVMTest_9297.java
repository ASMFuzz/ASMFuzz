public class MyJVMTest_9297 {

    void runTest() {
        java.lang.Math.multiplyExact(Long.MIN_VALUE, 7);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9297().runTest();
    }
}
