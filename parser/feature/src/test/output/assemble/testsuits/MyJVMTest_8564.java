import java.security.*;
import javax.xml.crypto.dsig.*;

public class MyJVMTest_8564 {

    static String algo = "H-'_/@=Vwu";

    static String mechType = "Gz`t;z:__e";

    TransformService TestTransformService(String algo, String mechType) throws Exception {
        TransformService ts = TransformService.getInstance(algo, mechType);
        Provider p = ts.getProvider();
        try {
            ts = TransformService.getInstance(algo, mechType, p);
            ts = TransformService.getInstance(algo, mechType, p.getName());
        } catch (Exception ex) {
            throw new RuntimeException("Error: Unexpected exception", ex);
        }
        return ts;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8564().TestTransformService(algo, mechType);
    }
}
