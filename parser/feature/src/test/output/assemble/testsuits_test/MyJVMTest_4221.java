import java.awt.*;
import javax.swing.*;

public class MyJVMTest_4221 {

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
        System.out.println(new MyJVMTest_4221().getMenuBar());
    }
}
