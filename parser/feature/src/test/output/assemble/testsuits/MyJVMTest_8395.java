import java.awt.*;

public class MyJVMTest_8395 {

    static String[] instructions = { "]vW9P-I4Q>", "c|'ely#p?1", "ikbB];^n/ ", "(%y1N0prNm", "{Jn@=*9ay{", "gSoM:\\{0Lw", "v]tE.\"@W$y", "FB%6?.{lWk", "B^7E4qV]G+", "%.W785B/nl" };

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
        new MyJVMTest_8395().printInstructions(instructions);
    }
}
