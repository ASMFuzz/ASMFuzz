import java.util.concurrent.*;
import javax.swing.*;

public class MyJVMTest_17957 {

    void test() throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JPopupMenu.Separator separator = new JPopupMenu.Separator();
        separator.getPreferredSize();
    }

    Void call() throws Exception {
        test();
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17957().call());
    }
}
