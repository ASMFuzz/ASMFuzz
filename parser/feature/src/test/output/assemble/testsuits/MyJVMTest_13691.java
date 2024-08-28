import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13691 {

    static String messageIn = ".3x{g@fu;y";

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
        new MyJVMTest_13691().displayMessage(messageIn, nextLine);
    }
}
