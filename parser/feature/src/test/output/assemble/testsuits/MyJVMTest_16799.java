import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class MyJVMTest_16799 {

    static File tempFolder = null;

    static File dir = null;

    void run() {
        FileSystemView.getFileSystemView().getFiles(tempFolder, false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16799().run();
    }
}
