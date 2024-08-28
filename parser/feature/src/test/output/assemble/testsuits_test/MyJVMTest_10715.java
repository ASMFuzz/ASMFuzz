import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_10715 {

    static String fParam1 = "lBQt2W#NMI";

    static File f = new File(fParam1);

    static String s = "1v|c>e{C7j";

    File writeFile(File f, String s) throws IOException {
        if (f.getParentFile() != null)
            f.getParentFile().mkdirs();
        FileWriter out = new FileWriter(f);
        try {
            out.write(s);
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10715().writeFile(f, s));
    }
}
