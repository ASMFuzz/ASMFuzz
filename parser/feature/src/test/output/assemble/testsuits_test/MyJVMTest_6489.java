import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;

public class MyJVMTest_6489 {

    static GraphicsConfiguration frameParam1 = null;

    static Frame frame = new Frame(frameParam1);

    MenuBar getMenuBar(final Frame frame) {
        final MenuBar menuBar = new MenuBar();
        frame.setMenuBar(menuBar);
        return menuBar;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6489().getMenuBar(frame));
    }
}
