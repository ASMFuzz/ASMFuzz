import java.io.*;
import java.net.*;

public class MyJVMTest_3660 {

    String getUrlContentType(String name) throws IOException {
        File file = new File(System.getProperty("test.src", "."), "xml");
        URL u = new URL("file:" + file.getCanonicalPath() + file.separator + name);
        URLConnection conn = u.openConnection();
        return conn.getContentType();
    }

    static String XML_MIME_TYPE = "application/xml";

    static int passed = 0, failed = 1;

    static String[] goodFiles = { "xml1", "xml2.xml", "xml3", "xml4" };

    static String[] badFiles = { "not-xml1", "not-xml2" };

    void contentTypeFromFile() throws Exception {
        for (String goodFile : goodFiles) {
            String result = getUrlContentType(goodFile);
            if (!XML_MIME_TYPE.equals(result)) {
                System.out.println("Wrong MIME type: " + goodFile + " --> " + result);
                failed++;
            } else {
                passed++;
            }
        }
        for (String badFile : badFiles) {
            String result = getUrlContentType(badFile);
            if (XML_MIME_TYPE.equals(result)) {
                System.out.println("Wrong MIME type: " + badFile + " --> " + result);
                failed++;
            } else {
                passed++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3660().contentTypeFromFile();
    }
}
