import java.security.*;

public class MyJVMTest_14405 {

    void tryAllPC() throws Exception {
        try {
            AllPermission p0 = new AllPermission("AllOfIt", "read");
            PermissionCollection pc = p0.newPermissionCollection();
            pc.setReadOnly();
            AllPermission p1 = new AllPermission("SomeOfIt", "read");
            pc.add(p1);
            throw new Exception("Failed...AllPermission added to readonly AllPermissionCollection.");
        } catch (SecurityException se) {
            System.out.println("AllPermissionCollection passed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14405().tryAllPC();
    }
}
