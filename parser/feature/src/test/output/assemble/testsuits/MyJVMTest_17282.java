import java.awt.image.*;

public class MyJVMTest_17282 {

    static int pixel = 6;

    int getAlpha(int pixel) {
        return 255;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17282().getAlpha(pixel));
    }
}
