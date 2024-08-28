import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4488 {

    static int rowIndex = 3;

    static int columnIndex = 9;

    Object getValueAt(int rowIndex, int columnIndex) {
        return "" + rowIndex + " " + columnIndex;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4488().getValueAt(rowIndex, columnIndex));
    }
}
