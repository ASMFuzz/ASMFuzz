import java.io.*;
import java.util.*;

public class MyJVMTest_11337 {

    static String fParam1Param1 = "lSJlKGMps/";

    static String fParam1Param2 = "NK(CqLgH\\[";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "#ul`9>PD0q";

    static File f = new File(fParam1, fParam2);

    static String body = "8Ua+EILGh[";

    static String opt = "f;={IX1B p";

    File writeFile(File f, String body) throws Exception {
        if (f.getParentFile() != null)
            f.getParentFile().mkdirs();
        Writer out = new FileWriter(f);
        try {
            out.write(body);
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11337().writeFile(f, body);
    }
}
