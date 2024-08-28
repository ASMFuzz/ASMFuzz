import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_15409 {

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodType MT_MethodHandle_invoke_SC2() {
        shouldNotCallThis();
        return methodType(String.class, String.class, char.class, char.class);
    }

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_MethodHandle_invoke_SC2() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findVirtual(MethodHandle.class, "invoke", MT_MethodHandle_invoke_SC2());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15409().MH_MethodHandle_invoke_SC2());
    }
}
