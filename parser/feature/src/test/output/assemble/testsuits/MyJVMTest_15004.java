public class MyJVMTest_15004 {

    void run() throws RuntimeException {
        boolean passed = false;
        String className = "j9vm.test.clinitexception.ClassWithClinitException";
        try {
            Class clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " not found");
        } catch (ExceptionInInitializerError e) {
            System.out.println("passed");
            passed = true;
        }
        if (!passed) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15004().run();
    }
}
