import java.security.*;
import javax.xml.crypto.dsig.*;

public class MyJVMTest_18155 {

    static String algo = "@65Ltf*7aD";

    static String mechType = "9^<p/<$X>J";

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
        new MyJVMTest_18155().TestTransformService(algo, mechType);
    }
}
