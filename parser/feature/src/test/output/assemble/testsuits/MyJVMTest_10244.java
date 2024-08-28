import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;

public class MyJVMTest_10244 {

    static JTable table = null;

    static Icon ICON = new Icon() {

        @Override
        public int getIconWidth() {
            return 24;
        }

        @Override
        public int getIconHeight() {
            return 24;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int w, int h) {
        }
    };

    int getIconWidth() {
        return 24;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10244().getIconWidth());
    }
}
