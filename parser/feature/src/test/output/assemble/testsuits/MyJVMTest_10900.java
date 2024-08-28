import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10900 {

    static String[] instructions = { "-3]} uupV(", "CrQ%xxc@hB", "'WJo0=]$ba", "BX`7h46 7h", "*N(tJfrhSe", ".Yw7h>MiU~", "BA'X^YHzo}", "E<VT+E/(7g", "-?$,%\"OfMh", "<^Q@]dQbBv" };

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 100;

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
        new MyJVMTest_10900().printInstructions(instructions);
    }
}
