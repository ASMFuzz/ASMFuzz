import java.io.*;

public class MyJVMTest_7188 {

    void m() throws IOException {
        try (Writer out = new StringWriter()) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7188().m();
    }
}
