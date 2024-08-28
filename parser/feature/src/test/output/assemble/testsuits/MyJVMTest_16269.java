import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16269 {

    static String[] instructions = { "byPEUg\\})7", "xSzZYA@ToK", "sZ82%Guogq", "t`6=Ws3q\"I", "D\\%-_lq`n~", "ya#>Vx|]^i", ":YP9~iP}BY", "EYgWj)O0Y9", "v+Z#He[LE\"", ":P\\{y3U}a#" };

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
        new MyJVMTest_16269().printInstructions(instructions);
    }
}
