import java.io.File;

public class MyJVMTest_16754 {

    static String[] args = { "t%b{Jpaym,", "DP$aQ^TW}m", ")RorCh{em~", "\\T=K,psLfg", "_8V9FTMY#<", "1H1bN=ifV ", "^=dA S$8=v", "z3$9+VJjSf", "i+gEpXpcX=", "r :b\" k90j" };

    static boolean removeSource = false;

    int parseOptions(String[] args) {
        int optionsEnd = 0;
        while (args[optionsEnd].startsWith("-")) {
            switch(args[optionsEnd].substring(1)) {
                case "r":
                    removeSource = true;
                    break;
                default:
                    throw new RuntimeException("Unrecognized option passed to CopyClassFile: " + args[optionsEnd]);
            }
            optionsEnd++;
        }
        return optionsEnd;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16754().parseOptions(args));
    }
}
