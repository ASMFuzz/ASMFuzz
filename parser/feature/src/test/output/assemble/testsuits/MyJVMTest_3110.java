import java.lang.ref.*;
import javax.naming.RefAddr;
import javax.naming.BinaryRefAddr;
import javax.naming.Reference;

public class MyJVMTest_3110 {

    static ReferenceQueue q = new ReferenceQueue();

    static String rParam1 = "Lb/o4Gx}8(";

    static String rParam2Param1 = "{6i983+g.o";

    static byte[] rParam2Param2 = { -86, 104, 25, -78, -13, 118, -89, 66, 95, -74 };

    static int rParam2Param3 = 537;

    static int rParam2Param4 = 584;

    static RefAddr rParam2 = new BinaryRefAddr(rParam2Param1, rParam2Param2, rParam2Param3, rParam2Param4);

    static String rParam3 = "4OLAnu?@W>";

    static String rParam4 = "Ob96F<AY07";

    static Reference r = new Reference(rParam1, rParam2, rParam3, rParam4);

    Reference test(ReferenceQueue q, Reference r) {
        if (!r.enqueue())
            throw new RuntimeException("Enqueue operation failed");
        return r;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3110().test(q, r);
    }
}
