import java.io.*;
import java.util.zip.*;

public class MyJVMTest_8746 {

    static String name = "11#K-MhwJ:";

    File writeTestFile(String name) throws IOException {
        File f = new File(name + ".java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class " + name + " { }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8746().writeTestFile(name));
    }
}
