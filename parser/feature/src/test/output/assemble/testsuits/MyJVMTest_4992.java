import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4992 {

    static String messageIn = "js5UE'+~7I";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 120;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4992().displayMessage(messageIn);
    }
}
