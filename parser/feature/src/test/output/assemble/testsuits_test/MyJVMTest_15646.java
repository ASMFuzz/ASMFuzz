import java.security.*;
import java.security.cert.*;
import javax.crypto.*;
import javax.net.ssl.*;
import javax.security.auth.login.*;
import java.lang.reflect.*;

public class MyJVMTest_15646 {

    static Method m = null;

    static Class expectedException = null;

    static Object args = 0;

    Class run(Method m, Class expectedException, Object... args) throws Exception {
        try {
            m.invoke(null, args);
            throw new Exception("Didn't throw exception");
        } catch (InvocationTargetException ite) {
            Throwable root = ite.getCause();
            if (root instanceof Exception) {
                Exception e = (Exception) root;
                if (expectedException.isInstance(e)) {
                    System.out.print("OK ");
                    return;
                } else {
                    System.out.println("Unexpected InvocationTargetException!");
                    throw e;
                }
            }
            throw ite;
        }
        return expectedException;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15646().run(m, expectedException, args);
    }
}
