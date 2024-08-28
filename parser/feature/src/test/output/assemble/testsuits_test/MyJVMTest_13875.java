import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13875 {

    static int rowIndex = 0;

    static int columnIndex = 4;

    Object getValueAt(int rowIndex, int columnIndex) {
        return "" + rowIndex + " " + columnIndex;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13875().getValueAt(rowIndex, columnIndex));
    }
}
