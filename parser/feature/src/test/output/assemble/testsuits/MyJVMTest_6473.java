public class MyJVMTest_6473 {

    void methodToDelete() {
        throw new RuntimeException("Test exception in methodToDelete");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6473().methodToDelete();
    }
}
