import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9847 {

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static PermissionCollection permissions = new Permissions();

    MethodType MT_MethodHandle_invoke_SC2() {
        shouldNotCallThis();
        return methodType(String.class, String.class, char.class, char.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9847().MT_MethodHandle_invoke_SC2());
    }
}
