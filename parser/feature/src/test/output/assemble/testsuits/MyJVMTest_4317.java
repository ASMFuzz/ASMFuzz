import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_4317 {

    static String messageIn = "WpY9^Pt kH";

    static boolean nextLine = false;

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    static Panel buttonP = new Panel();

    static Button passB = new Button("pass");

    static Button failB = new Button("fail");

    String displayMessage(String messageIn, boolean nextLine) {
        messageText.append(messageIn + (nextLine ? "\n" : ""));
        System.out.println(messageIn);
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4317().displayMessage(messageIn, nextLine);
    }
}
