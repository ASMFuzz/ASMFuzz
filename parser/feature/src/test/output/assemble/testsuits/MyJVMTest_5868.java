import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class MyJVMTest_5868 {

    static VirtualFile root = new VirtualFile("testdir", true);

    void init() {
        JFileChooser chooser = new JFileChooser(new VirtualFileSystemView());
        chooser.setCurrentDirectory(root);
        chooser.showSaveDialog(null);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5868().init();
    }
}
