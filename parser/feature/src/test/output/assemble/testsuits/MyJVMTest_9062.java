import java.io.*;

public class MyJVMTest_9062 {

    File writeTestFile() throws IOException {
        File f = new File("Test.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class Test { ");
        out.println("    @Deprecated static final int f1 = 3;");
        out.println("    @Deprecated int f2;");
        out.println("    @Deprecated void m() throws Exception, Error { }");
        out.println("}");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9062().writeTestFile());
    }
}
