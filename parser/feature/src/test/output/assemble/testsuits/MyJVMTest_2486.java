import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.io.*;

public class MyJVMTest_2486 {

    static String fileName = null;

    static DocFlavor flavor = null;

    static Object printData = null;

    Object getPrintData() {
        if (this.printData == null) {
            this.printData = URLDoc.class.getResource(this.fileName);
            System.out.println("getPrintData(): " + this.printData);
        }
        return this.printData;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2486().getPrintData());
    }
}
