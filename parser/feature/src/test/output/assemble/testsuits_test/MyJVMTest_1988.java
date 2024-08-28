import java.io.*;

public class MyJVMTest_1988 {

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
        new MyJVMTest_1988().run();
    }
}
