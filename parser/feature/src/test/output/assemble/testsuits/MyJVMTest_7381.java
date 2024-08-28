import java.io.*;

public class MyJVMTest_7381 {

    File writeTestFile() throws IOException {
        File f = new File("Test.java");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        out.println("class Test<T> { }");
        out.close();
        return f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7381().writeTestFile());
    }
}
