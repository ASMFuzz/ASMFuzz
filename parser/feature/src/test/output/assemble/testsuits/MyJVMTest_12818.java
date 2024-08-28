import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12818 {

    static String[] instructions = { "q\"5Rule{5l", "fHT(%Ouvn ", "W3i%oDfPY0", "!RLxMMgnAW", "7n8GYBKbZe", "a?I6*T_>]$", "PL@zv|Q)X7", ";!z&\\Q[&k(", "Sc&sG!a?a.", "St&fDoY]<n" };

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 120;

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
        new MyJVMTest_12818().printInstructions(instructions);
    }
}
