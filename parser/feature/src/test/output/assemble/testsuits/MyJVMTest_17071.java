import java.io.*;
import java.net.*;
import java.security.*;
import java.lang.reflect.*;

public class MyJVMTest_17071 {

    static String codesourceParam1Param1Param1Param1Param1Param1Param1 = "u9$htn}a6[";

    static String codesourceParam1Param1Param1Param1Param1Param1Param2 = "uGld-6@&j*";

    static int codesourceParam1Param1Param1Param1Param1Param1Param3 = 529;

    static String codesourceParam1Param1Param1Param1Param1Param1Param4 = "S'Y)k6oBNu";

    static URLStreamHandler codesourceParam1Param1Param1Param1Param1Param1Param5 = null;

    static URL codesourceParam1Param1Param1Param1Param1Param1 = new URL(codesourceParam1Param1Param1Param1Param1Param1Param1, codesourceParam1Param1Param1Param1Param1Param1Param2, codesourceParam1Param1Param1Param1Param1Param1Param3, codesourceParam1Param1Param1Param1Param1Param1Param4, codesourceParam1Param1Param1Param1Param1Param1Param5);

    static String codesourceParam1Param1Param1Param1Param1Param2 = "'{1r}PV]{A";

    static URLStreamHandler codesourceParam1Param1Param1Param1Param1Param3 = null;

    static URL codesourceParam1Param1Param1Param1Param1 = new URL(codesourceParam1Param1Param1Param1Param1Param1, codesourceParam1Param1Param1Param1Param1Param2, codesourceParam1Param1Param1Param1Param1Param3);

    static String codesourceParam1Param1Param1Param1Param2 = "6:?w1^c]RI";

    static URL codesourceParam1Param1Param1Param1 = new URL(codesourceParam1Param1Param1Param1Param1, codesourceParam1Param1Param1Param1Param2);

    static String codesourceParam1Param1Param1Param2 = "`*<LOEEmuy";

    static URLStreamHandler codesourceParam1Param1Param1Param3 = null;

    static URL codesourceParam1Param1Param1 = new URL(codesourceParam1Param1Param1Param1, codesourceParam1Param1Param1Param2, codesourceParam1Param1Param1Param3);

    static String codesourceParam1Param1Param2 = "*Zms1\"m}'R";

    static URLStreamHandler codesourceParam1Param1Param3 = null;

    static URL codesourceParam1Param1 = new URL(codesourceParam1Param1Param1, codesourceParam1Param1Param2, codesourceParam1Param1Param3);

    static String codesourceParam1Param2 = "wX7h\\F#VEk";

    static URL codesourceParam1 = new URL(codesourceParam1Param1, codesourceParam1Param2);

    static CodeSigner[] codesourceParam2 = { null, null, null, null, null, null, null, null, null, null };

    static CodeSource codesource = new CodeSource(codesourceParam1, codesourceParam2);

    PermissionCollection getPermissions(CodeSource codesource) {
        Permissions perms = new Permissions();
        perms.add(new AllPermission());
        return perms;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17071().getPermissions(codesource));
    }
}
