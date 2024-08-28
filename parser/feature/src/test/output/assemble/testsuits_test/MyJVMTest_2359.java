import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_2359 {

    static String[] instructions = { "@#\" ~ MB0g", "/2Wwi`n4Nz", "_6i0L}15n}", "5F-#2mzO6C", "@0Hwp3GZud", "O?M'C973'`", "x[Z5'yrGCq", "|V,}\"Rs1b/", "'oiM|#Se-!", "XYT$wm`VQs" };

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
        new MyJVMTest_2359().printInstructions(instructions);
    }
}
