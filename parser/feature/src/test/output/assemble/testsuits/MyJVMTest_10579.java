import java.awt.*;

public class MyJVMTest_10579 {

    static Frame frame = null;

    static TextField textField = null;

    static Button button = null;

    void createAndShowGUI() {
        frame = new Frame("AWTFocusTransitionTest");
        frame.setSize(300, 300);
        frame.setFocusTraversalPolicyProvider(true);
        frame.setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        textField = new TextField();
        button = new Button();
        Panel panel = new Panel();
        panel.setFocusTraversalPolicyProvider(true);
        panel.setFocusTraversalPolicy(new DefaultFocusTraversalPolicy());
        Panel p = new Panel();
        p.setLayout(new GridLayout(3, 1));
        p.add(textField);
        p.add(button);
        p.add(panel);
        frame.add(p);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10579().createAndShowGUI();
    }
}
