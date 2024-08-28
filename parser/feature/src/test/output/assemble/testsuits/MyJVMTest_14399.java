import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14399 {

    static String messageIn = "hv\"BvH7 U|";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 120;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14399().displayMessage(messageIn);
    }
}
