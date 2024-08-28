import javax.swing.*;
import java.awt.*;

public class MyJVMTest_4561 {

    static int row = 0;

    static int col = -1288184213;

    boolean isCellEditable(int row, int col) {
        return (col == 4);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4561().isCellEditable(row, col));
    }
}
