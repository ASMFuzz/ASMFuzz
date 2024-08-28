import java.io.*;
import java.util.*;

public class MyJVMTest_2091 {

    static String fParam1 = "I|,jIPW8Z ";

    static File f = new File(fParam1);

    static String body = "vJL>JxA|)J";

    static String opt = "]V*%#-Q7U{";

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
        new MyJVMTest_2091().writeFile(f, body);
    }
}
