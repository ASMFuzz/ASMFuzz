import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_2847 {

    static String fParam1 = "Xole;]T6@F";

    static String fParam2 = ">a+hf (Ie6";

    static File f = new File(fParam1, fParam2);

    static File file = null;

    File other(File f) {
        return f.getAbsoluteFile();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2847().other(f));
    }
}
