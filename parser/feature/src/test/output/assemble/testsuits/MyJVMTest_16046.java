import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class MyJVMTest_16046 {

    static CharSequence bufferParam1 = null;

    static StringBuilder buffer = new StringBuilder(bufferParam1);

    static int length = 0;

    StringBuilder createFiller(StringBuilder buffer, int length) {
        buffer.append("<FILLER>");
        int fillLength = length - "<FILLER></FILLER>".length();
        for (int i = 0; i < fillLength; i++) {
            buffer.append('f');
        }
        buffer.append("</FILLER>");
        return buffer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16046().createFiller(buffer, length);
    }
}
