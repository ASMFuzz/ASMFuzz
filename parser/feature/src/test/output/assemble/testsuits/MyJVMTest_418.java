public class MyJVMTest_418 {

    void methodToRedefine() {
        throw new RuntimeException("Test exception");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_418().methodToRedefine();
    }
}
