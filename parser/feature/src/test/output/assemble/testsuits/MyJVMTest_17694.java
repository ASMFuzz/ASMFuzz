import java.io.*;
import java.util.*;
import java.net.URI;

public class MyJVMTest_17694 {

    static String dirParam1Param1Param1 = "\\}9dlv9{Pk";

    static String dirParam1Param1Param2 = "2H .Y\"pj(G";

    static String dirParam1Param1Param3 = "^Fd;2-FW%w";

    static String dirParam1Param1Param4 = "3+aCEFB&l6";

    static URI dirParam1Param1 = new URI(dirParam1Param1Param1, dirParam1Param1Param2, dirParam1Param1Param3, dirParam1Param1Param4);

    static File dirParam1 = new File(dirParam1Param1);

    static String dirParam2 = "]S U\"*mO]&";

    static File dir = new File(dirParam1, dirParam2);

    static String path = "+H\"]o|PJT7";

    static String body = "=^*\"m<93r`";

    File writeFile(File dir, String path, String body) throws IOException {
        File f = new File(dir, path);
        f.getParentFile().mkdirs();
        try (FileWriter out = new FileWriter(f)) {
            out.write(body);
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17694().writeFile(dir, path, body));
    }
}
