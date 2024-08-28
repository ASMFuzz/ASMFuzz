import java.io.*;
import java.util.zip.*;

public class MyJVMTest_16040 {

    static String name = "mG[n?;+ywN";

    File writeTestFile(String name) throws IOException {
        File f = new File(name + ".java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class " + name + " { }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16040().writeTestFile(name));
    }
}
