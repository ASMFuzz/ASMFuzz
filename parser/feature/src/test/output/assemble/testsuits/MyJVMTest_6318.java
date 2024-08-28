import java.security.*;
import sun.security.provider.*;
import java.net.URL;

public class MyJVMTest_6318 {

    static String domainParam1Param1Param1 = "aoTnYFe3v/";

    static URL domainParam1Param1 = new URL(domainParam1Param1Param1);

    static CodeSigner[] domainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource domainParam1 = new CodeSource(domainParam1Param1, domainParam1Param2);

    static PermissionCollection domainParam2 = null;

    static ProtectionDomain domain = new ProtectionDomain(domainParam1, domainParam2);

    static Permission perm = new AllPermission();

    static Policy p = null;

    boolean engineImplies(ProtectionDomain domain, Permission perm) {
        return p.implies(domain, perm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6318().engineImplies(domain, perm));
    }
}
