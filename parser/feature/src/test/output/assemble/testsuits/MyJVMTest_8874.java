import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8874 {

    static String messageIn = "+_\\'WjXJ)k";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8874().displayMessage(messageIn);
    }
}
