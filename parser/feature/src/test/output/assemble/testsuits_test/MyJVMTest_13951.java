import javax.swing.*;
import java.awt.*;

public class MyJVMTest_13951 {

    static int row = 0;

    static int col = 5;

    boolean isCellEditable(int row, int col) {
        return (col == 4);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13951().isCellEditable(row, col));
    }
}
