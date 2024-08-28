import java.awt.*;

public class MyJVMTest_9866 {

    static GraphicsConfiguration windowParam1 = null;

    static Frame window = new Frame(windowParam1);

    Dimension getClientSize(Frame window) {
        Dimension size = window.getSize();
        Insets insets = window.getInsets();
        System.out.println("getClientSize() for " + window);
        System.out.println("   size: " + size);
        System.out.println("   insets: " + insets);
        return new Dimension(size.width - insets.left - insets.right, size.height - insets.top - insets.bottom);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9866().getClientSize(window));
    }
}
