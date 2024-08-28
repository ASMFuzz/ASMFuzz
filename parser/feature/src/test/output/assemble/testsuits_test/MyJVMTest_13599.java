import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_13599 {

    static String eParam1 = "e'XNv@-j>[";

    static Locator eParam2 = null;

    static String eParam3Param1 = "CBooBL9!)|";

    static String eParam3Param2Param1 = "9'18,Ri]Vf";

    static Throwable eParam3Param2 = new Throwable(eParam3Param2Param1);

    static Exception eParam3 = new Exception(eParam3Param1, eParam3Param2);

    static SAXParseException e = new SAXParseException(eParam1, eParam2, eParam3);

    SAXParseException error(SAXParseException e) throws SAXException {
        throw e;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13599().error(e);
    }
}
