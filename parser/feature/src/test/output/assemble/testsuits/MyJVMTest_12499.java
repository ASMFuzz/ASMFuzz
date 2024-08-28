import javax.swing.*;

public class MyJVMTest_12499 {

    static JEditorPane editor = null;

    void run() {
        editor.setText("Hello world!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12499().run();
    }
}
