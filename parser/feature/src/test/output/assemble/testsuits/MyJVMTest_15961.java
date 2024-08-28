public class MyJVMTest_15961 {

    void methodToDelete() {
        throw new RuntimeException("Test exception in methodToDelete");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15961().methodToDelete();
    }
}
