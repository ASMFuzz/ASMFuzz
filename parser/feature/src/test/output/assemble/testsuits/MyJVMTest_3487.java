import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3487 {

    static String[] instructions = { "+i%h08`g5k", "7a~UcL`Q]A", "uNQ%rSU7nB", "{H'# uzRv}", "4Vw/9gH\\xT", ";tRBqp`7}I", "tF*+120f$e", "NC``aI9BEj", "EK49<`Hx*n", "T}5VL9?7Dc" };

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
        new MyJVMTest_3487().printInstructions(instructions);
    }
}
