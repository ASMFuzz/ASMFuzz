import javax.swing.*;

public class MyJVMTest_3183 {

    static JEditorPane editor = null;

    void run() {
        editor.setText("Hello world!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3183().run();
    }
}
