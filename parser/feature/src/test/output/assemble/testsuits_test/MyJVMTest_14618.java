import javax.swing.*;
import java.awt.*;

public class MyJVMTest_14618 {

    static JFileChooser chooser = new JFileChooser();

    void run() {
        chooser.showOpenDialog(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14618().run();
    }
}
