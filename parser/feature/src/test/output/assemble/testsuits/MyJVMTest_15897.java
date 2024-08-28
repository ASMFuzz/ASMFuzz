import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15897 {

    static String messageIn = "1Uxdxqe:(w";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    static Panel buttonP = new Panel();

    static Button passB = new Button("pass");

    static Button failB = new Button("fail");

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15897().displayMessage(messageIn);
    }
}
