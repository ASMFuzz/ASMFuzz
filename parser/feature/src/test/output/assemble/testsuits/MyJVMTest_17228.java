import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_17228 {

    static String eParam1 = "08UB(_zV_Q";

    static String eParam2 = "54r,!FcW\\o";

    static String eParam3 = "vPI=3yl|>}";

    static int eParam4 = 504;

    static int eParam5 = 139;

    static Exception eParam6 = new Exception();

    static SAXParseException e = new SAXParseException(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    static boolean fail = false;

    SAXParseException fatalError(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        if (e.getMessage().indexOf("bad_value") < 0) {
            fail = true;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17228().fatalError(e);
    }
}
