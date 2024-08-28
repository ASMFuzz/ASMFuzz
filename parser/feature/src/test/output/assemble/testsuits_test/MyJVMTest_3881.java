public class MyJVMTest_3881 {

    void sync_shouldnt_be_tested() {
    }

    void should_pass() {
        sync_shouldnt_be_tested();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3881().should_pass();
    }
}
