import java.security.AccessController;
import java.security.Permission;

public class MyJVMTest_17483 {

    static Permission permission = null;

    Void run() {
        AccessController.checkPermission(permission);
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17483().run());
    }
}
