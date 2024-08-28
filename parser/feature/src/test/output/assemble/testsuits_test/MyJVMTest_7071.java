import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7071 {

    static JTable table = null;

    int getRowCount() {
        return 20;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7071().getRowCount());
    }
}
