import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5201 {

    static JFileChooser chooser = new JFileChooser();

    void run() {
        chooser.showOpenDialog(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5201().run();
    }
}
