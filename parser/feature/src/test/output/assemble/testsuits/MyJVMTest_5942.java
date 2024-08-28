import java.awt.image.*;

public class MyJVMTest_5942 {

    static int pixel = 1;

    int getBlue(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5942().getBlue(pixel));
    }
}
