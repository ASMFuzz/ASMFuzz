import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1678 {

    static String[] instructions = { "`f.{%YkPe<", "4ItA=4fX~4", "J/9DXu>+'(", "*RwdD{S'*J", "+hm_Ti KWU", "`N5@\",RFJ,", "wJP}<(!O:i", "Isuh0ZgBfK", "M91Xnb<zi}", "PhM~vz=$]6" };

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
        new MyJVMTest_1678().printInstructions(instructions);
    }
}
