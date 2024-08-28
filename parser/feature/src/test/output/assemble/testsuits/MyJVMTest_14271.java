public class MyJVMTest_14271 {

    static boolean passed = true;

    void run() {
        try {
            Class.forName("j9vm.test.clinit.NewTestHelper");
        } catch (ClassNotFoundException t) {
            passed = false;
            throw new RuntimeException(t);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14271().run();
    }
}
