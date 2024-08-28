import java.awt.Image;
import java.awt.image.BufferedImage;

public class MyJVMTest_5968 {

    static int type = 8;

    Image getIcon(int type) {
        return new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5968().getIcon(type));
    }
}
