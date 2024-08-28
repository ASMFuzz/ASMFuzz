public class MyJVMTest_1594 {

    static boolean passed = true;

    void run() {
        try {
            Class.forName("j9vm.test.clinit.PutStaticTestHelper");
        } catch (ClassNotFoundException t) {
            passed = false;
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1594().run();
    }
}
