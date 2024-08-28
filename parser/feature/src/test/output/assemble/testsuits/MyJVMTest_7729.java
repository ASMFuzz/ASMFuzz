import java.awt.image.*;

public class MyJVMTest_7729 {

    static int pixel = 0;

    int getAlpha(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7729().getAlpha(pixel));
    }
}
