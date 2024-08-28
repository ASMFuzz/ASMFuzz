public class MyJVMTest_11178 {

    void methodToDelete() {
        throw new RuntimeException("Test exception in methodToDelete");
    }

    void callMethodToDelete() {
        methodToDelete();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11178().callMethodToDelete();
    }
}
