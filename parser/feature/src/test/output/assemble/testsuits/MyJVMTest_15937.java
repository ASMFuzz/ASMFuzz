import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;

public class MyJVMTest_15937 {

    static int rowIndex = 944480977;

    static int columnIndex = 7;

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

    Object getValueAt(int rowIndex, int columnIndex) {
        return (columnIndex == 1 ? ICON : 4);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15937().getValueAt(rowIndex, columnIndex));
    }
}
