import javax.swing.*;
import java.awt.*;

public class MyJVMTest_8958 {

    static String[] instructions = { "E7 .F21ewS", "f3MY1?<oW!", "VMe%eTov#L", "SMt#=-w?\\8", "/^=<6Xan6D", "7;LNkNuP.@", "xQ[b2he_C0", "{B)~3)?Tux", "9a*Zg6Ym6?", "7 rcesA7lG" };

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
        new MyJVMTest_8958().printInstructions(instructions);
    }
}
