import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_15185 {

    static String fParam1 = "I,{Wtx_7vg";

    static String fParam2 = "H2:4.tCnyz";

    static File f = new File(fParam1, fParam2);

    static File file = null;

    File other(File f) {
        return new File("not_" + f.getPath());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15185().other(f));
    }
}
