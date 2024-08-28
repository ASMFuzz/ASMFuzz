import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_11621 {

    static String[] instructions = { "~>5A/I&U* ", "Je'L/*~AU'", "@BQ|dzlO)G", "vPV{]f/3D8", "+A9qZ`fzL)", "l{}HkEib>Z", "'\"{RnFf)-G", "m8)65h?Jn9", "qpVuJoXYUr", "!i7hdO[4Bj" };

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    String printInstructions(String[] instructions) {
        instructionsText.setText("");
        String printStr, remainingStr;
        for (int i = 0; i < instructions.length; i++) {
            remainingStr = instructions[i];
            while (remainingStr.length() > 0) {
                if (remainingStr.length() >= maxStringLength) {
                    int posOfSpace = remainingStr.lastIndexOf(' ', maxStringLength - 1);
                    if (posOfSpace <= 0)
                        posOfSpace = maxStringLength - 1;
                    printStr = remainingStr.substring(0, posOfSpace + 1);
                    remainingStr = remainingStr.substring(posOfSpace + 1);
                } else {
                    printStr = remainingStr;
                    remainingStr = "";
                }
                instructionsText.append(printStr + "\n");
            }
        }
        return remainingStr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11621().printInstructions(instructions);
    }
}
