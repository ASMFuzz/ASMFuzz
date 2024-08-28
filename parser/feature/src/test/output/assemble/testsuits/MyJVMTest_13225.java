public class MyJVMTest_13225 {

    void sync_shouldnt_be_tested() {
    }

    void should_pass() {
        sync_shouldnt_be_tested();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13225().should_pass();
    }
}
