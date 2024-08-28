public class MyJVMTest_13838 {

    static String CLASS_TO_LOAD = "ParentlessChild";

    static int ATTEMPTS = 10;

    void test() {
        for (int i = 0; i < ATTEMPTS; i++) {
            try {
                Class.forName(CLASS_TO_LOAD);
                System.err.println("Error: Class.forName(" + CLASS_TO_LOAD + ") should not have succeeded!");
            } catch (java.lang.ClassNotFoundException exc) {
            } catch (java.lang.NoClassDefFoundError err) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13838().test();
    }
}
