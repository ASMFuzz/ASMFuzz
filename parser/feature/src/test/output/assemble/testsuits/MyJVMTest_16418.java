import java.io.*;

public class MyJVMTest_16418 {

    void m() throws IOException {
        try (Writer out = new StringWriter()) {
            out.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16418().m();
    }
}
