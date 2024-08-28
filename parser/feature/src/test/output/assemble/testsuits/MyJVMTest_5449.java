import java.io.*;

public class MyJVMTest_5449 {

    File writeTestFile() throws IOException {
        File f = new File("Test.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("@Deprecated class Test { int f; void m() { } }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5449().writeTestFile());
    }
}
