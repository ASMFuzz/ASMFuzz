import java.security.Permission;
import java.security.AllPermission;

public class MyJVMTest_4588 {

    static Permission perm = new AllPermission();

    static String ACCESS_CLIPBOARD = "accessClipboard";

    static boolean isCheckPermissionCalled = false;

    Permission checkPermission(Permission perm) {
        if (ACCESS_CLIPBOARD.equals(perm.getName())) {
            isCheckPermissionCalled = true;
        }
        return perm;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4588().checkPermission(perm);
    }
}
