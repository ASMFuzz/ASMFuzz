public class MyJVMTest_9887 {

    static boolean passed = true;

    void run() {
        try {
            Class.forName("j9vm.test.clinit.GetStaticTestHelper");
        } catch (ClassNotFoundException t) {
            passed = false;
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9887().run();
    }
}
