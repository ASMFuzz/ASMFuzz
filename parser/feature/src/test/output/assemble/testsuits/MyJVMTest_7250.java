import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_7250 {

    static String fParam1 = "mW>LTAMKWi";

    static File f = new File(fParam1);

    static String s = "$)ve!h8Za`";

    FileWriter writeFile(File f, String s) throws IOException {
        f.getParentFile().mkdirs();
        FileWriter out = new FileWriter(f);
        try {
            out.write(s);
        } finally {
            out.close();
        }
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7250().writeFile(f, s);
    }
}
