import java.security.Permission;
import java.security.PermissionCollection;

public class MyJVMTest_16663 {

    static int mask = 4;

    PermissionCollection newPermissionCollection() {
        return new TVPermissionCollection();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16663().newPermissionCollection());
    }
}
