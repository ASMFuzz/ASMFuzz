import java.util.concurrent.*;
import javax.swing.*;

public class MyJVMTest_10966 {

    void test() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JPopupMenu.Separator separator = new JPopupMenu.Separator();
        separator.getPreferredSize();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10966().test();
    }
}
