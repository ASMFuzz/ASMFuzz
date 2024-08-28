import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1611 {

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    MethodType MT_Class_forName_S() {
        shouldNotCallThis();
        return methodType(Class.class, String.class);
    }

    static PermissionCollection permissions = new Permissions();

    MethodHandle MH_Class_forName_S() throws ReflectiveOperationException {
        shouldNotCallThis();
        return lookup().findStatic(Class.class, "forName", MT_Class_forName_S());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1611().MH_Class_forName_S());
    }
}
