import java.io.*;
import java.net.*;
import java.security.*;
import java.lang.reflect.*;

public class MyJVMTest_9231 {

    static String domainParam1Param1Param1 = "Jk&[t=}%i!";

    static String domainParam1Param1Param2 = "U\\6aa-?]q?";

    static String domainParam1Param1Param3 = "cU %X&CA:}";

    static URL domainParam1Param1 = new URL(domainParam1Param1Param1, domainParam1Param1Param2, domainParam1Param1Param3);

    static Certificate[] domainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource domainParam1 = new CodeSource(domainParam1Param1, domainParam1Param2);

    static PermissionCollection domainParam2 = null;

    static ProtectionDomain domain = new ProtectionDomain(domainParam1, domainParam2);

    static Permission permission = new AllPermission();

    static ProtectionDomain allPermClassDomain = null;

    boolean implies(ProtectionDomain domain, Permission permission) {
        if (domain == allPermClassDomain) {
            throw new SecurityException("Unexpected call into AllPermPolicy");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9231().implies(domain, permission));
    }
}
