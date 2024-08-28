import java.awt.*;

public class MyJVMTest_17978 {

    static String[] instructions = { "K:]Ws*+ek\\", "9Pg,~`>z2#", "iHy6r.X;GI", "{L2>QHoO?>", "8l`K6ZO|N3", "L$xCLnh0s6", "aUtTRaej9Y", "r'ph`,>;K)", "8^Xp+w&6Ee", "|KS~.X|Bc?" };

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
                    if (posOfSpace <= 0) {
                        posOfSpace = maxStringLength - 1;
                    }
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
        new MyJVMTest_17978().printInstructions(instructions);
    }
}
