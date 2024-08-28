import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5511 {

    int getEmptyPixel() {
        return 0xFFFFFFFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5511().getEmptyPixel());
    }
}
