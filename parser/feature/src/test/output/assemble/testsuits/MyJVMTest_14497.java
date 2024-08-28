import java.io.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;

public class MyJVMTest_14497 {

    File writeTestFile() throws IOException {
        File f = new File("Test.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class Test { }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14497().writeTestFile());
    }
}
