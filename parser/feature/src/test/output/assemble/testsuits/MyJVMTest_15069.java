import java.io.*;
import java.net.*;

public class MyJVMTest_15069 {

    byte[] toBOMBytes(String encoding) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        switch(encoding) {
            case "UTF-8":
                bos.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                break;
            case "UTF-16BE":
                bos.write(new byte[] { (byte) 0xFE, (byte) 0xFF });
                break;
            case "UTF-16LE":
                bos.write(new byte[] { (byte) 0xFF, (byte) 0xFE });
                break;
            case "UTF-32BE":
                bos.write(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0xFE, (byte) 0xFF });
                break;
            case "UTF-32LE":
                bos.write(new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0x00, (byte) 0x00 });
        }
        bos.write(XML_HEADER.getBytes(encoding));
        return bos.toByteArray();
    }

    static String XML_MIME_TYPE = "application/xml";

    static String XML_HEADER = "<?xml";

    static int passed = 0, failed = 9;

    void contentTypeFromBOMStream() throws Exception {
        final String[] encodings = new String[] { "UTF-8", "UTF-16BE", "UTF-16LE", "UTF-32BE", "UTF-32LE" };
        for (String encoding : encodings) {
            try (InputStream is = new ByteArrayInputStream(toBOMBytes(encoding))) {
                String mime = URLConnection.guessContentTypeFromStream(is);
                if (!XML_MIME_TYPE.equals(mime)) {
                    System.out.println("Wrong MIME type: " + encoding + " --> " + mime);
                    failed++;
                } else {
                    passed++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15069().contentTypeFromBOMStream();
    }
}
