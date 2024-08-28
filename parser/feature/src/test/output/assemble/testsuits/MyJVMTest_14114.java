import java.awt.*;
import java.awt.print.*;
import java.awt.geom.*;
import javax.swing.*;

public class MyJVMTest_14114 {

    static PrinterJob printerJob = null;

    int getNumberOfPages() {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14114().getNumberOfPages());
    }
}
