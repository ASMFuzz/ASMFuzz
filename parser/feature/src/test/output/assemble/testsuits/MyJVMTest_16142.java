import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class MyJVMTest_16142 {

    static String testString = "UY96J6|8?.";

    static int bufferLimitPosition = -13551303;

    void createFiller(StringBuilder buffer, int length) {
        buffer.append("<FILLER>");
        int fillLength = length - "<FILLER></FILLER>".length();
        for (int i = 0; i < fillLength; i++) {
            buffer.append('f');
        }
        buffer.append("</FILLER>");
    }

    String createDocument(String testString, int bufferLimitPosition) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append("<?xml version=\"1.1\"?>");
        result.append("<ROOT>");
        int fillerLength = 8192 - bufferLimitPosition;
        createFiller(result, fillerLength);
        result.append(testString);
        createFiller(result, 9000);
        result.append("</ROOT>");
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16142().createDocument(testString, bufferLimitPosition));
    }
}
