import java.util.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;

public class MyJVMTest_9510 {

    static PermissionCollection permissions = new Permissions();

    void shouldNotCallThis() {
        if (System.getProperty("MethodHandleConstants.allow-untransformed") != null)
            return;
        throw new AssertionError("this code should be statically transformed away by Indify");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9510().shouldNotCallThis();
    }
}
