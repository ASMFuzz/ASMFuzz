import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_1600 {

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    static PermissionCollection permissions = new Permissions();

    MethodType MT_String_replace_C2() {
        shouldNotCallThis();
        return methodType(String.class, char.class, char.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1600().MT_String_replace_C2());
    }
}
