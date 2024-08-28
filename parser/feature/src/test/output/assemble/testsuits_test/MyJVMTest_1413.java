import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class MyJVMTest_1413 {

    static String found = "+O,7z-oAjE";

    static String expected = "P(-\\r+T9;5";

    static String document = "F&HgF98`AL";

    static int errCount = 0;

    String checkContent(String found, String expected, String document) {
        if (!(found.equals(expected))) {
            errCount++;
            int bufferStart = "<?xml version=\"1.1\"?><ROOT>".length() + 1;
            int bufferStart2 = bufferStart + 8192;
            System.err.println("\nError:: expected \"" + expected + "\", but found \"" + found + "\"!");
            System.err.println("Buffer was (probably): [ ... " + document.substring(bufferStart2 - 20, bufferStart2) + "] [" + document.substring(bufferStart2, bufferStart2 + 30) + " ... ]");
        }
        return document;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1413().checkContent(found, expected, document);
    }
}
