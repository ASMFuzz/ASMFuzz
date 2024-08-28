import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4560 {

    static int row = 3;

    static int column = 0;

    static JTable table = null;

    Object getValueAt(int row, int column) {
        return "(" + row + "," + column + ")";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4560().getValueAt(row, column));
    }
}
