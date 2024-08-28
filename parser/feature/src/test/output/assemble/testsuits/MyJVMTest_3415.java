import java.awt.image.*;

public class MyJVMTest_3415 {

    static int pixel = 1216386021;

    int getRed(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3415().getRed(pixel));
    }
}
