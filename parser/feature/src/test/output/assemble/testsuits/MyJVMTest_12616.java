import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.print.*;

public class MyJVMTest_12616 {

    static String messageIn = "x)]BY+y4e[";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    static Panel buttonP = new Panel();

    static Button passB = new Button("pass");

    static Button failB = new Button("fail");

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12616().displayMessage(messageIn);
    }
}
