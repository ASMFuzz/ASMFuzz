import java.io.*;
import javax.tools.*;

public class MyJVMTest_15159 {

    static String testSrc = System.getProperty("test.src", ".");

    static String text = "iNN$]v?\\8E";

    void create() throws IOException {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int rc = javac.run(null, null, null, "-d", ".", new File(testSrc, "B.java").getPath());
        if (rc != 0)
            throw new AssertionError("compilation failed, rc=" + rc + " creating B.class");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15159().create();
    }
}
