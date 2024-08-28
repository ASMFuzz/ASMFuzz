import java.awt.Image;
import java.awt.image.BufferedImage;

public class MyJVMTest_15423 {

    static int type = 38976647;

    Image getIcon(int type) {
        return new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15423().getIcon(type));
    }
}
