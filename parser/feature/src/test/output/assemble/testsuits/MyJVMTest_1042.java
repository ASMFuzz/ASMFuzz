import javax.swing.*;
import java.awt.*;

public class MyJVMTest_1042 {

    static JTable table = null;

    int getColumnCount() {
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1042().getColumnCount());
    }
}
