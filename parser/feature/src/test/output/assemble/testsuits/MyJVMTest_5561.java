import java.security.AccessControlContext;

public class MyJVMTest_5561 {

    static ProtectionDomain[] acc1Param1Param1 = { null, null, null, null, null, null, null, null, null, null };

    static AccessControlContext acc1Param1 = new AccessControlContext(acc1Param1Param1);

    static DomainCombiner acc1Param2 = null;

    static AccessControlContext acc1 = new AccessControlContext(acc1Param1, acc1Param2);

    static ProtectionDomain[] acc2Param1Param1Param1Param1Param1Param1Param1 = { null, null, null, null, null, null, null, null, null, null };

    static AccessControlContext acc2Param1Param1Param1Param1Param1Param1 = new AccessControlContext(acc2Param1Param1Param1Param1Param1Param1Param1);

    static DomainCombiner acc2Param1Param1Param1Param1Param1Param2 = null;

    static AccessControlContext acc2Param1Param1Param1Param1Param1 = new AccessControlContext(acc2Param1Param1Param1Param1Param1Param1, acc2Param1Param1Param1Param1Param1Param2);

    static DomainCombiner acc2Param1Param1Param1Param1Param2 = null;

    static AccessControlContext acc2Param1Param1Param1Param1 = new AccessControlContext(acc2Param1Param1Param1Param1Param1, acc2Param1Param1Param1Param1Param2);

    static DomainCombiner acc2Param1Param1Param1Param2 = null;

    static AccessControlContext acc2Param1Param1Param1 = new AccessControlContext(acc2Param1Param1Param1Param1, acc2Param1Param1Param1Param2);

    static DomainCombiner acc2Param1Param1Param2 = null;

    static AccessControlContext acc2Param1Param1 = new AccessControlContext(acc2Param1Param1Param1, acc2Param1Param1Param2);

    static DomainCombiner acc2Param1Param2 = null;

    static AccessControlContext acc2Param1 = new AccessControlContext(acc2Param1Param1, acc2Param1Param2);

    static DomainCombiner acc2Param2 = null;

    static AccessControlContext acc2 = new AccessControlContext(acc2Param1, acc2Param2);

    AccessControlContext testEquals(AccessControlContext acc1, AccessControlContext acc2) throws Exception {
        if (!acc1.equals(acc2)) {
            throw new Exception("AccessControlContexts should be equal");
        }
        return acc1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5561().testEquals(acc1, acc2);
    }
}
