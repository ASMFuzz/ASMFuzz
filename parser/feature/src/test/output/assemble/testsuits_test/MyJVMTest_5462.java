import java.awt.*;
import java.awt.color.*;
import java.awt.image.*;

public class MyJVMTest_5462 {

    static boolean failed = false;

    static BufferedImage original = null;

    static ColorConvertOp colorOp = null;

    void run() {
        try {
            colorOp.filter(original, null);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            failed = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5462().run();
    }
}
