import java.lang.reflect.*;

public class MyJVMTest_17043 {

    static int failed = 0;

    void testGetMethods() {
        Method[] m = new Integer[0][0][0].getClass().getMethods();
        for (Method mm : m) if (mm.getName().contentEquals("clone")) {
            failed++;
            System.out.println("getMethods() Should not find clone()");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17043().testGetMethods();
    }
}
