import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_14796 {

    static String fileName = null;

    static DocFlavor flavor = null;

    DocAttributeSet getAttributes() {
        HashDocAttributeSet hset = new HashDocAttributeSet();
        return hset;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14796().getAttributes());
    }
}
