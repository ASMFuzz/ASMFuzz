import java.awt.*;
import javax.swing.*;

public class MyJVMTest_13585 {

    JMenuBar getMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem mi = new JMenuItem("test");
        menu.add(mi);
        return menuBar;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13585().getMenuBar());
    }
}
