import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15569 {

    static Frame frame = null;

    static Button button = null;

    static boolean actionTriggered = false;

    void init() {
        frame = new Frame();
        frame.setLayout(new FlowLayout());
        button = new Button("button");
        button.addActionListener(actionEvent -> {
            actionTriggered = true;
        });
        frame.add(button);
        frame.setBounds(100, 100, 200, 200);
        frame.setVisible(true);
        frame.validate();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15569().init();
    }
}
