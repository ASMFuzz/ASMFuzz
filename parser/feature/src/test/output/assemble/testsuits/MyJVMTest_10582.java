import java.awt.*;
import java.awt.font.*;
import javax.swing.*;

public class MyJVMTest_10582 {

    static int w = 400, h = 250;

    static String str = null;

    static Font font = null;

    Dimension preferredSize() {
        return new Dimension(w, h);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10582().preferredSize());
    }
}
