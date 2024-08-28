import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import java.io.*;

public class MyJVMTest_16603 {

    static String fileName = null;

    static DocFlavor flavor = null;

    DocFlavor getDocFlavor() {
        return DocFlavor.URL.AUTOSENSE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16603().getDocFlavor());
    }
}
