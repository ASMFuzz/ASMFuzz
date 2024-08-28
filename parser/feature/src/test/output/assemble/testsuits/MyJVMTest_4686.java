import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_4686 {

    static Image testImage = null;

    GraphicsConfiguration getDefaultGC() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4686().getDefaultGC());
    }
}
