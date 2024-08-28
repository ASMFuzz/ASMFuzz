import java.io.*;

public class MyJVMTest_6908 {

    void m() throws IOException {
        try (Writer out = new StringWriter()) {
            out.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6908().m();
    }
}
