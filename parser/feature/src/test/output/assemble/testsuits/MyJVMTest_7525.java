import java.security.AccessController;
import java.security.PrivilegedAction;

public class MyJVMTest_7525 {

    String getPropertyPrivDC(final String prop) {
        return AccessController.doPrivilegedWithCombiner(new PrivilegedAction<String>() {

            public String run() {
                System.out.println("Codetrusted - getPropertyPrivDC prop = " + prop);
                return System.getProperty(prop);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7525().run());
    }
}
