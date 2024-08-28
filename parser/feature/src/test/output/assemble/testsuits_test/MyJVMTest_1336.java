import javax.swing.*;
import java.awt.*;

public class MyJVMTest_1336 {

    static int argb = 5;

    int getEmptyPixel() {
        return 0xFFFFFFFF;
    }

    boolean isPixelEmpty(int argb) {
        return (argb & 0x00FFFFFF) == (getEmptyPixel() & 0x00FFFFFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1336().isPixelEmpty(argb));
    }
}
