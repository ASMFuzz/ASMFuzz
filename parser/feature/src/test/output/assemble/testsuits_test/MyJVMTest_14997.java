import java.security.AccessControlContext;

public class MyJVMTest_14997 {

    static ProtectionDomain[] acc1Param1 = { null, null, null, null, null, null, null, null, null, null };

    static AccessControlContext acc1 = new AccessControlContext(acc1Param1);

    static ProtectionDomain[] acc2Param1 = { null, null, null, null, null, null, null, null, null, null };

    static AccessControlContext acc2 = new AccessControlContext(acc2Param1);

    AccessControlContext testEquals(AccessControlContext acc1, AccessControlContext acc2) throws Exception {
        if (!acc1.equals(acc2)) {
            throw new Exception("AccessControlContexts should be equal");
        }
        return acc1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14997().testEquals(acc1, acc2);
    }
}
