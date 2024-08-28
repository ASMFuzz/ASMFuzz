import java.io.*;

public class MyJVMTest_16711 {

    void m() throws IOException {
        try (Writer out = new StringWriter()) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16711().m();
    }
}
