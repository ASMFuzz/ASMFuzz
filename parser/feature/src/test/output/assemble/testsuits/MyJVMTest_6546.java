import java.io.*;
import java.util.zip.*;

public class MyJVMTest_6546 {

    static String name = "GPxGA]XIdL";

    File writeTestFile(String name) throws IOException {
        File f = new File(name + ".java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class " + name + " { }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6546().writeTestFile(name));
    }
}
