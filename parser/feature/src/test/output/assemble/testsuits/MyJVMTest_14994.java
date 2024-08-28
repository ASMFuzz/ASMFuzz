import java.awt.*;
import javax.swing.*;

public class MyJVMTest_14994 {

    static JLabel htmlComponent = null;

    void createAndShowGUI() {
        String htmlText = "<html>" + "<head><style> .blue{ color:blue; } </style></head>" + "<body" + "<P class=\"blue\"> should be rendered with BLUE class definition</P>" + "</body>";
        JFrame mainFrame = new JFrame("bug4251579");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        htmlComponent = new JLabel(htmlText);
        mainFrame.getContentPane().add(htmlComponent);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14994().createAndShowGUI();
    }
}
