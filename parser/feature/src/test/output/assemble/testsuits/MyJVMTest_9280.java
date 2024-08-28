public class MyJVMTest_9280 {

    static boolean passed = true;

    void run() {
        try {
            Class.forName("j9vm.test.clinit.InvokeStaticTestHelper");
        } catch (ClassNotFoundException t) {
            passed = false;
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9280().run();
    }
}
