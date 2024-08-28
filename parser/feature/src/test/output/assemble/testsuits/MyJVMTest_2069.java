import javax.swing.*;

public class MyJVMTest_2069 {

    static JEditorPane editor = null;

    void run() {
        editor = new JEditorPane("text/html", "Hello world!");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2069().run();
    }
}
