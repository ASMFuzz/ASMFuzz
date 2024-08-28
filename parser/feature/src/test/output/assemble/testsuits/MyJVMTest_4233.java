import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_4233 {

    static String eParam1 = "j _G'ZL1;'";

    static String eParam2 = "Cl+\\ISXVH{";

    static String eParam3 = "lxtSiJ{/t@";

    static int eParam4 = 669;

    static int eParam5 = 539;

    static Exception eParam6 = new Exception();

    static SAXParseException e = new SAXParseException(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    SAXParseException error(SAXParseException e) throws SAXException {
        throw e;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4233().error(e);
    }
}
