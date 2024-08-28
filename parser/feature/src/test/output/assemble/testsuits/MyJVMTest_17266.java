import java.awt.image.*;

public class MyJVMTest_17266 {

    static int pixel = 0;

    int getGreen(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17266().getGreen(pixel));
    }
}
