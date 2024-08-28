import java.io.File;
import javax.swing.JApplet;
import javax.swing.JFileChooser;

public class MyJVMTest_16241 {

    static VirtualFile root = new VirtualFile("testdir", true);

    void init() {
        JFileChooser chooser = new JFileChooser(new VirtualFileSystemView());
        chooser.setCurrentDirectory(root);
        chooser.showOpenDialog(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16241().init();
    }
}
