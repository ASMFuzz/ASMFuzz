import java.lang.reflect.*;

public class MyJVMTest_17346 {

    static int failed = 0;

    void testGetDeclaredMethod() {
        try {
            Method m = new Object[0][0].getClass().getDeclaredMethod("clone", (Class<?>[]) null);
            failed++;
            System.out.println("getDeclaredMethod(\"clone\", null) Should not find clone()");
        } catch (NoSuchMethodException e) {
            ;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17346().testGetDeclaredMethod();
    }
}
