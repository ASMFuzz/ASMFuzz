import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_14080 {

    static Image testImage = null;

    GraphicsConfiguration getDefaultGC() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14080().getDefaultGC());
    }
}
