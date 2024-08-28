import java.awt.image.BufferedImage;

public class MyJVMTest_12335 {

    BufferedImage createTestImage() {
        return new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12335().createTestImage());
    }
}
