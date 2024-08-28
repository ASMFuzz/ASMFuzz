import java.awt.*;

public class MyJVMTest_8503 {

    static int status = 2;

    void run() {
        Runtime.getRuntime().halt(status);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8503().run();
    }
}
