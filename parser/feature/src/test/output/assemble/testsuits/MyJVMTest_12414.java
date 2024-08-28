import java.lang.reflect.*;

public class MyJVMTest_12414 {

    static int failed = 0;

    void testGetMethod() {
        try {
            Method m = new String[0].getClass().getMethod("clone", (Class<?>[]) null);
            failed++;
            System.out.println("getMethod(\"clone\", null) Should not find clone()");
        } catch (NoSuchMethodException e) {
            ;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12414().testGetMethod();
    }
}
