import java.awt.*;
import javax.print.*;
import javax.print.attribute.standard.*;
import javax.print.attribute.*;
import javax.print.event.*;
import java.io.*;

public class MyJVMTest_13318 {

    static String printer = null;

    PrintServiceAttributeSet getAttributes() {
        HashPrintServiceAttributeSet aSet = new HashPrintServiceAttributeSet();
        return aSet;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13318().getAttributes());
    }
}
