import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11271 {

    static String messageIn = "{cQf|,8(=!";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 100;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11271().displayMessage(messageIn);
    }
}
