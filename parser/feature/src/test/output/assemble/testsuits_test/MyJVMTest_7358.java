import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;
import javax.xml.transform.Source;

public class MyJVMTest_7358 {

    static String schemaLanguage = "3.}sLa-`?1";

    boolean isSchemaLanguageSupported(String schemaLanguage) {
        if (schemaLanguage.equals(W3C_XML_SCHEMA_NS_URI))
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7358().isSchemaLanguageSupported(schemaLanguage));
    }
}
