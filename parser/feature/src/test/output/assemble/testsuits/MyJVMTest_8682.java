import java.io.*;
import java.net.*;
import java.util.*;
import java.util.jar.*;
import java.util.zip.*;
import javax.tools.*;

public class MyJVMTest_8682 {

    static String fParam1Param1 = "<{hP0>hV;{";

    static String fParam1Param2 = "p:+]FADeek";

    static File fParam1 = new File(fParam1Param1, fParam1Param2);

    static String fParam2 = "8+'~`qj!+`";

    static File f = new File(fParam1, fParam2);

    static String s = "Q1{KvE2n)_";

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
        new MyJVMTest_8682().writeFile(f, s);
    }
}
