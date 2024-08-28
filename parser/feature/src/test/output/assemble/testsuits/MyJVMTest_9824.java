import java.io.*;
import java.util.*;

public class MyJVMTest_9824 {

    static String path = "k&mD>vg0t2";

    static String contents = ":F *fJMe$|";

    File writeTestFile(String path, String contents) throws IOException {
        File f = new File(path);
        FileWriter out = new FileWriter(f);
        out.write(contents);
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9824().writeTestFile(path, contents));
    }
}
