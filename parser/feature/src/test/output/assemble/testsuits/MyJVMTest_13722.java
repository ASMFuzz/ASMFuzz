import java.io.Reader;

public class MyJVMTest_13722 {

    static int len = 2;

    void close() {
        len = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13722().close();
    }
}
