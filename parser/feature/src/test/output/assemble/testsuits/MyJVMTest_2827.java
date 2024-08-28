import java.awt.Dialog;
import java.awt.Frame;

public class MyJVMTest_2827 {

    static String frameParam1 = "q|$lpk~ZSZ";

    static GraphicsConfiguration frameParam2 = null;

    static Frame frame = new Frame(frameParam1, frameParam2);

    static int i = -1502739632;

    Frame showDialog(final Frame frame, final int i) {
        final Dialog visible = new Dialog(frame);
        visible.setLocationRelativeTo(null);
        visible.setVisible(true);
        if (i % 2 == 0) {
            new Dialog(frame);
        }
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2827().showDialog(frame, i);
    }
}
