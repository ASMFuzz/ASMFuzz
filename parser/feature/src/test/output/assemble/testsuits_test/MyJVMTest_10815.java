public class MyJVMTest_10815 {

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
        new MyJVMTest_10815().run();
    }
}
