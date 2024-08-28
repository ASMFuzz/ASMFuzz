import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_8135 {

    static ExternalSub s = null;

    static MethodType M_T = MethodType.methodType(String.class);

    ExternalSub checkExternalSub(ExternalSub s) throws Throwable {
        try {
            lookup().findVirtual(ExternalSub.class, "priv_invoke", M_T);
            throw new Error("Unexpected access to ExternalSub.priv_invoke");
        } catch (IllegalAccessException iae) {
            System.out.println("Got expected exception accessing ExternalSub.priv_invoke:" + iae);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8135().checkExternalSub(s);
    }
}
