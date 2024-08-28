import java.security.*;
import javax.xml.crypto.dsig.*;

public class MyJVMTest_5028 {

    void TestXMLSignatureFactory() throws Exception {
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance();
        Provider p = fac.getProvider();
        String mechType = fac.getMechanismType();
        Provider p2;
        try {
            fac = XMLSignatureFactory.getInstance(mechType);
            p2 = fac.getProvider();
            fac = XMLSignatureFactory.getInstance(mechType, p);
            fac = XMLSignatureFactory.getInstance(mechType, p.getName());
        } catch (Exception ex) {
            throw new RuntimeException("Error: Unexpected exception", ex);
        }
        if (p2.getName() != p.getName()) {
            throw new RuntimeException("Error: Provider equality check failed");
        }
        if (p2.getName() != p.getName()) {
            throw new RuntimeException("Error: Provider equality check failed");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5028().TestXMLSignatureFactory();
    }
}
