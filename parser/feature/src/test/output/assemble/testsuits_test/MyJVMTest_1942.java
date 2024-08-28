public class MyJVMTest_1942 {

    void methodToDelete() {
        throw new RuntimeException("Test exception in methodToDelete");
    }

    void callMethodToDelete() {
        methodToDelete();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1942().callMethodToDelete();
    }
}
