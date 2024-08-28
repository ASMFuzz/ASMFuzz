import java.security.*;
import sun.security.provider.*;
import java.net.URL;

public class MyJVMTest_15796 {

    static String domainParam1Param1Param1 = "Aiobi0LAAG";

    static String domainParam1Param1Param2 = "5]ho;~iD:y";

    static int domainParam1Param1Param3 = 41;

    static String domainParam1Param1Param4 = "3cDWT4?.d`";

    static URLStreamHandler domainParam1Param1Param5 = null;

    static URL domainParam1Param1 = new URL(domainParam1Param1Param1, domainParam1Param1Param2, domainParam1Param1Param3, domainParam1Param1Param4, domainParam1Param1Param5);

    static Certificate[] domainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource domainParam1 = new CodeSource(domainParam1Param1, domainParam1Param2);

    static PermissionCollection domainParam2 = null;

    static ProtectionDomain domain = new ProtectionDomain(domainParam1, domainParam2);

    static Permission perm = new AllPermission();

    static Policy p = null;

    boolean engineImplies(ProtectionDomain domain, Permission perm) {
        return p.implies(domain, perm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15796().engineImplies(domain, perm));
    }
}
