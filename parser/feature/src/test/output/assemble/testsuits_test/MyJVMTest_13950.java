import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13950 {

    static int row = 0;

    static int column = 2;

    static JTable table = null;

    Object getValueAt(int row, int column) {
        return "(" + row + "," + column + ")";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13950().getValueAt(row, column));
    }
}
