import java.io.*;
import java.util.*;

public class MyJVMTest_654 {

    static String path = "yHwCt?xGZF";

    static String contents = ".(@Y6\\PV[8";

    File writeTestFile(String path, String contents) throws IOException {
        File f = new File(path);
        FileWriter out = new FileWriter(f);
        out.write(contents);
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_654().writeTestFile(path, contents));
    }
}
