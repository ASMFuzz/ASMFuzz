import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_16994 {

    static ExternalSuper s = null;

    static MethodType M_T = MethodType.methodType(String.class);

    ExternalSuper checkExternalSuper(ExternalSuper s) throws Throwable {
        try {
            lookup().findVirtual(ExternalSuper.class, "priv_invoke", M_T);
            throw new Error("Unexpected access to ExternalSuper.priv_invoke");
        } catch (IllegalAccessException iae) {
            System.out.println("Got expected exception accessing ExternalSuper.priv_invoke:" + iae);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16994().checkExternalSuper(s);
    }
}
