import java.io.*;
import java.util.*;

public class MyJVMTest_503 {

    static String path = "-;.ZlnTseR";

    static String body = "~Xl*:g@ezD";

    File writeFile(String path, String body) throws IOException {
        File f = new File(path);
        FileWriter out = new FileWriter(f);
        try {
            out.write(body);
        } finally {
            out.close();
        }
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_503().writeFile(path, body));
    }
}
