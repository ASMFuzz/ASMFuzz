public class MyJVMTest_9575 {

    void methodToRedefine() {
        throw new RuntimeException("Test exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9575().methodToRedefine();
    }
}
