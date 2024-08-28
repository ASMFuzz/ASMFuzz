public class MyJVMTest_4871 {

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
        new MyJVMTest_4871().run();
    }
}
