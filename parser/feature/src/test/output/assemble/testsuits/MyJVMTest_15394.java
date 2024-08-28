import java.awt.image.*;

public class MyJVMTest_15394 {

    static int pixel = 927512810;

    int getBlue(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15394().getBlue(pixel));
    }
}
