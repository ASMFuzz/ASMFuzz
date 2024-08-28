import java.awt.*;

public class MyJVMTest_1229 {

    static int status = 2;

    void run() {
        status = 0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            status = 1;
            System.exit(status);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1229().run();
    }
}
