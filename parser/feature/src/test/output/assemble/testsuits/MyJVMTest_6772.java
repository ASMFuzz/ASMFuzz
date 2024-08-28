import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6772 {

    static String[] instructions = { "?3s\"SWPL^9", "6x4'h(sXTT", "D=5}w~G\"5d", "]_f#-[zxSr", "<dJ~|[]=K_", "~9Utu3?~ F", "nr-J2='&$s", "irzA-RC$;/", "0j\"P6!{O0b", "(a{Gae=+&<" };

    static TextArea instructionsText = null;

    static TextArea messageText = null;

    static int maxStringLength = 80;

    static Panel buttonP = new Panel();

    static Button passB = new Button("pass");

    static Button failB = new Button("fail");

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
        new MyJVMTest_6772().printInstructions(instructions);
    }
}
