import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_8482 {

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static PermissionCollection permissions = new Permissions();

    MethodType MT_Class_forName_S() {
        shouldNotCallThis();
        return methodType(Class.class, String.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8482().MT_Class_forName_S());
    }
}
