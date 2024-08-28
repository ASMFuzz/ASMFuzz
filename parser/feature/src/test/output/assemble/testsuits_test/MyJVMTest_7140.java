import java.security.Permission;
import java.security.PermissionCollection;

public class MyJVMTest_7140 {

    static int mask = 1;

    PermissionCollection newPermissionCollection() {
        return new TVPermissionCollection();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7140().newPermissionCollection());
    }
}
