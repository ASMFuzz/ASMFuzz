import java.awt.*;
import java.text.*;
import java.awt.font.*;
import java.awt.print.*;

public class MyJVMTest_5645 {

    static String messageIn = "lI=OFu==<g";

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    String displayMessage(String messageIn) {
        messageText.append(messageIn + "\n");
        return messageIn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5645().displayMessage(messageIn);
    }
}
