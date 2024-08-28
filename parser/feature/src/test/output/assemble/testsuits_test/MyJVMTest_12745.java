import java.awt.image.*;

public class MyJVMTest_12745 {

    static int pixel = 0;

    int getRed(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12745().getRed(pixel));
    }
}
