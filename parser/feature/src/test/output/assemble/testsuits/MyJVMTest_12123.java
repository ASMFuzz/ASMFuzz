import java.awt.Dialog;
import java.awt.Frame;

public class MyJVMTest_12123 {

    static Frame frame = new Frame();

    static int i = 0;

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
        new MyJVMTest_12123().showDialog(frame, i);
    }
}
