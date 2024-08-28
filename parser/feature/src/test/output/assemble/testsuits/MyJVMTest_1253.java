import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MyJVMTest_1253 {

    static String eParam1 = "URZImDl6x5";

    static String eParam2 = "/n?SH3TR<r";

    static String eParam3 = "SylvL\"=+%[";

    static int eParam4 = 181;

    static int eParam5 = 481;

    static SAXParseException e = new SAXParseException(eParam1, eParam2, eParam3, eParam4, eParam5);

    SAXParseException fatalError(SAXParseException e) throws SAXException {
        throw e;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1253().fatalError(e);
    }
}
