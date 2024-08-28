import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.transform.Source;

public class MyJVMTest_16887 {

    static String schemaLanguage = "YRw]7m82in";

    boolean isSchemaLanguageSupported(String schemaLanguage) {
        if (schemaLanguage.equals(W3C_XML_SCHEMA_NS_URI))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16887().isSchemaLanguageSupported(schemaLanguage));
    }
}
