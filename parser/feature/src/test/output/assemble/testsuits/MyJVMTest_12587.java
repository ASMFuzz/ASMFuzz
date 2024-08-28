import java.io.*;

public class MyJVMTest_12587 {

    File writeTestFile() throws IOException {
        File f = new File("Outer.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class Outer {");
        out.println("    class Inner { }");
        out.println("}");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12587().writeTestFile());
    }
}
