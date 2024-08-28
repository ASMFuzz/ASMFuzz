import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_2027 {

    static String messageIn = "0tpp?g'2X|";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 100;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2027().displayMessage(messageIn);
    }
}
