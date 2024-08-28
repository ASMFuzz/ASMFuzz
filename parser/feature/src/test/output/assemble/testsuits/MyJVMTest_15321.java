import java.io.*;

public class MyJVMTest_15321 {

    static PipedOutputStream os = null;

    void run() {
        try {
            os.write(0);
            os.write(0);
            os.write(0);
            os.write(0);
            os.write(0);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15321().run();
    }
}
