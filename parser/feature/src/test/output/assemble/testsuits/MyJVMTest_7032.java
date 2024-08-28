import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_7032 {

    static String messageIn = "qn@d,2|Q=Z";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7032().displayMessage(messageIn);
    }
}
