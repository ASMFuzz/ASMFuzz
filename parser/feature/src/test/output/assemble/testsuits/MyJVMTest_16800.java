import java.io.*;
import java.util.*;

public class MyJVMTest_16800 {

    File writeTestFile() throws IOException {
        File f = new File("Test.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("abstract class Test { ");
        out.println("  public void public_m() { }");
        out.println("  protected void protected_m() { }");
        out.println("  private void private_m() { }");
        out.println("  void package_m() { }");
        out.println("}");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16800().writeTestFile());
    }
}
