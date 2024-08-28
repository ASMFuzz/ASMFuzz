import java.io.*;
import java.util.*;
import java.util.jar.*;
import java.net.URI;

public class MyJVMTest_1498 {

    static String fParam1Param1 = "'`D{+CSh90";

    static String fParam1Param2 = "U%TTgaH!^=";

    static String fParam1Param3 = "Y{n`PYEI,2";

    static String fParam1Param4 = "{\\6eEu+H>t";

    static String fParam1Param5 = "r]U+3SfB>x";

    static URI fParam1 = new URI(fParam1Param1, fParam1Param2, fParam1Param3, fParam1Param4, fParam1Param5);

    static File f = new File(fParam1);

    static String s = "Xt?_*ry0M0";

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
        System.out.println(new MyJVMTest_1498().writeFile(f, s));
    }
}
