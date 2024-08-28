import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14943 {

    int getEmptyPixel() {
        return 0xFFFFFFFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14943().getEmptyPixel());
    }
}
