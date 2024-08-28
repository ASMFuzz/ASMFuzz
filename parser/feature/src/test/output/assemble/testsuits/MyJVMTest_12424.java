import java.lang.ref.*;
import javax.naming.Reference;

public class MyJVMTest_12424 {

    static ReferenceQueue q = new ReferenceQueue();

    static String rParam1 = "Wn)TN~\"fmd";

    static String rParam2 = "%5Sv,I@=;}";

    static String rParam3 = "r;N}O.\"3nx";

    static Reference r = new Reference(rParam1, rParam2, rParam3);

    Reference test(ReferenceQueue q, Reference r) {
        if (!r.enqueue())
            throw new RuntimeException("Enqueue operation failed");
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12424().test(q, r);
    }
}
