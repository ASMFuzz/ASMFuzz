import java.security.*;

public class MyJVMTest_14305 {

    void tryBasicPC() throws Exception {
        try {
            MyBasicPermission p0 = new MyBasicPermission("BasicPermision");
            PermissionCollection pc = p0.newPermissionCollection();
            pc.setReadOnly();
            MyBasicPermission p1 = new MyBasicPermission("EvenMoreBasic");
            pc.add(p1);
            throw new Exception("Failed...BasicPermission added to readonly BasicPermissionCollection.");
        } catch (SecurityException se) {
            System.out.println("BasicPermissionCollection passed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14305().tryBasicPC();
    }
}
