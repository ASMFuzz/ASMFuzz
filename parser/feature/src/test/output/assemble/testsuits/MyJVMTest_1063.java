import java.io.*;
import java.util.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_1063 {

    static String fParam1 = "[,6^B^NXWR";

    static File f = new File(fParam1);

    static File file = null;

    File other(File f) {
        return new File(f.getPath().toUpperCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1063().other(f));
    }
}
