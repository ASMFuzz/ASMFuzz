import java.awt.image.*;

public class MyJVMTest_7714 {

    static int pixel = 2;

    int getGreen(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7714().getGreen(pixel));
    }
}
