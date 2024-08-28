import java.security.*;
import sun.security.provider.*;
import java.net.URL;

public class MyJVMTest_9087 {

    static String domainParam1Param1Param1Param1Param1 = ")XL)YLF[_;";

    static String domainParam1Param1Param1Param1Param2 = "tS2{Pd?{3\\";

    static String domainParam1Param1Param1Param1Param3 = "SCP*f-&<K\"";

    static URL domainParam1Param1Param1Param1 = new URL(domainParam1Param1Param1Param1Param1, domainParam1Param1Param1Param1Param2, domainParam1Param1Param1Param1Param3);

    static String domainParam1Param1Param1Param2 = "w9XVtV[Mv|";

    static URLStreamHandler domainParam1Param1Param1Param3 = null;

    static URL domainParam1Param1Param1 = new URL(domainParam1Param1Param1Param1, domainParam1Param1Param1Param2, domainParam1Param1Param1Param3);

    static String domainParam1Param1Param2 = "}Di m,i=2\"";

    static URLStreamHandler domainParam1Param1Param3 = null;

    static URL domainParam1Param1 = new URL(domainParam1Param1Param1, domainParam1Param1Param2, domainParam1Param1Param3);

    static CodeSigner[] domainParam1Param2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource domainParam1 = new CodeSource(domainParam1Param1, domainParam1Param2);

    static PermissionCollection domainParam2 = null;

    static ProtectionDomain domain = new ProtectionDomain(domainParam1, domainParam2);

    static String permParam1 = "HTNQBkML]f";

    static String permParam2 = "8KL(@H2i@H";

    static Permission perm = new AllPermission(permParam1, permParam2);

    static Policy p = null;

    boolean engineImplies(ProtectionDomain domain, Permission perm) {
        return p.implies(domain, perm);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9087().engineImplies(domain, perm));
    }
}
