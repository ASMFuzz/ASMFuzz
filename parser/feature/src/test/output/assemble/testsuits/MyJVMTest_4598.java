import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;
import java.util.Arrays;

public class MyJVMTest_4598 {

    static DocFlavor[] supportedDocFlavors = (new DocFlavor[] { javax.print.DocFlavor.INPUT_STREAM.JPEG });

    static String printer = null;

    DocFlavor[] getSupportedDocFlavors() {
        int i = supportedDocFlavors.length;
        DocFlavor[] adocflavor = new DocFlavor[i];
        System.arraycopy(supportedDocFlavors, 0, adocflavor, 0, i);
        return adocflavor;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_4598().getSupportedDocFlavors()));
    }
}
