public class MyJVMTest_711 {

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
        new MyJVMTest_711().run();
    }
}
