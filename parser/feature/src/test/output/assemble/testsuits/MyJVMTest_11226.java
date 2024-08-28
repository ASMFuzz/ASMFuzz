import java.io.*;

public class MyJVMTest_11226 {

    static PipedOutputStream os = null;

    void run() {
        try {
            os.write(0);
            os.write(0);
            os.write(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11226().run();
    }
}
