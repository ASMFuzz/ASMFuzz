import java.io.*;
import java.net.*;
import java.security.*;
import java.lang.reflect.*;

public class MyJVMTest_87 {

    static String domainParam1Param1Param1 = "@CRN\\R9#f*";

    static URL domainParam1Param1 = new URL(domainParam1Param1Param1);

    static Certificate[] domainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource domainParam1 = new CodeSource(domainParam1Param1, domainParam1Param2);

    static PermissionCollection domainParam2 = null;

    static ProtectionDomain domain = new ProtectionDomain(domainParam1, domainParam2);

    static String permissionParam1 = "j[F&E6e6K#";

    static String permissionParam2 = "S@jl_w\\Wn{";

    static Permission permission = new AllPermission(permissionParam1, permissionParam2);

    static ProtectionDomain allPermClassDomain = null;

    boolean implies(ProtectionDomain domain, Permission permission) {
        if (domain == allPermClassDomain) {
            throw new SecurityException("Unexpected call into AllPermPolicy");
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_87().implies(domain, permission));
    }
}
