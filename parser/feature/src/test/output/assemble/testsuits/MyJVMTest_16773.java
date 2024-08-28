import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_16773 {

    static String fParam1 = "SJU>A!It?<";

    static String fParam2 = "$I\"\\X#Rlb7";

    static File f = new File(fParam1, fParam2);

    static String s = "gwJpja7k(9";

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
        new MyJVMTest_16773().writeFile(f, s);
    }
}
