import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_7676 {

    static String eParam1 = "3:fT39%D*L";

    static Locator eParam2 = null;

    static SAXParseException e = new SAXParseException(eParam1, eParam2);

    static boolean fail = false;

    SAXParseException fatalError(SAXParseException e) throws SAXException {
        System.out.println(e.getMessage());
        if (e.getMessage().indexOf("bad_value") < 0) {
            fail = true;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7676().fatalError(e);
    }
}
