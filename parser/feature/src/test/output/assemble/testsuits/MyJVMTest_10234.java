import javax.swing.*;
import java.awt.*;

public class MyJVMTest_10234 {

    static JTable table = null;

    int getColumnCount() {
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10234().getColumnCount());
    }
}
