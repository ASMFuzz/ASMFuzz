import java.io.Reader;

public class MyJVMTest_4348 {

    static int len = -1549365994;

    void close() {
        len = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4348().close();
    }
}
