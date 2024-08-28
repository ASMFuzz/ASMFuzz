import java.awt.*;

public class MyJVMTest_12586 {

    static String msg = "&F#VU,3Th6";

    static Frame frame = new Frame();

    String fail(String msg) {
        frame.dispose();
        throw new RuntimeException(msg);
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12586().fail(msg);
    }
}
