import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;
import java.applet.Applet;

public class MyJVMTest_13051 {

    void initImpl() {
        imPr = new THTMLProducer();
        imPr.begin();
    }

    static DataFlavor[] HTMLFlavors = null;

    static THTMLProducer imPr = null;

    void init() {
        initImpl();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13051().init();
    }
}
