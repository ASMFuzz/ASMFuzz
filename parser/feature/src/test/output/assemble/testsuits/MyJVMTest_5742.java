import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_5742 {

    static String fParam1 = "vFfPr;$yRy";

    static File f = new File(fParam1);

    static File file = null;

    File other(File f) {
        return new File("not_" + f.getPath());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5742().other(f));
    }
}
