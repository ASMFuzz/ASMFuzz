import java.lang.reflect.*;

public class MyJVMTest_17893 {

    static int failed = 0;

    void testGetDeclaredMethods() {
        Method[] m = new Throwable[0][0][0][0].getClass().getDeclaredMethods();
        if (m.length != 0) {
            failed++;
            System.out.println("getDeclaredMethods().length should be 0");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17893().testGetDeclaredMethods();
    }
}
