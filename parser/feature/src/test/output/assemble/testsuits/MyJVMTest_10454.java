import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_10454 {

    static String eParam1 = "rT;ArLwL<n";

    static String eParam2 = "YS62,x[S:5";

    static String eParam3 = "xs'%cs7l7/";

    static int eParam4 = 660;

    static int eParam5 = 902;

    static Exception eParam6 = new Exception();

    static SAXParseException e = new SAXParseException(eParam1, eParam2, eParam3, eParam4, eParam5, eParam6);

    SAXParseException fatalError(SAXParseException e) throws SAXException {
        throw e;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10454().fatalError(e);
    }
}
