import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class MyJVMTest_6552 {

    static String bufferParam1 = "bt1=MROcE4";

    static StringBuilder buffer = new StringBuilder(bufferParam1);

    static int length = 9;

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
        new MyJVMTest_6552().createFiller(buffer, length);
    }
}
