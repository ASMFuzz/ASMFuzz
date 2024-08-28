import java.io.File;
import javax.swing.JApplet;
import javax.swing.JFileChooser;

public class MyJVMTest_6744 {

    static VirtualFile root = new VirtualFile("testdir", true);

    void init() {
        JFileChooser chooser = new JFileChooser(new VirtualFileSystemView());
        chooser.setCurrentDirectory(root);
        chooser.showOpenDialog(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6744().init();
    }
}
