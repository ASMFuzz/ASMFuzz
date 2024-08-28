import java.io.*;
import java.util.*;

public class MyJVMTest_8124 {

    static String dirParam1 = "uCb)g8)l@}";

    static String dirParam2 = "(/=g+t<XU?";

    static File dir = new File(dirParam1, dirParam2);

    static String path = "Q(f^RhN,;}";

    static String body = "G{~CC% w<i";

    File writeFile(File dir, String path, String body) throws IOException {
        File f = new File(dir, path);
        f.getParentFile().mkdirs();
        try (FileWriter out = new FileWriter(f)) {
            out.write(body);
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8124().writeFile(dir, path, body));
    }
}
