import java.text.*;
import java.util.*;

public class MyJVMTest_15680 {

    static String formatted = "<ae+yEp'+]";

    static String numSystem = "$d}AMmb2j5";

    boolean checkResult(String formatted, String numSystem) {
        switch(numSystem) {
            case "arab":
                return formatted.charAt(0) == '\u0661';
            case "latn":
                return formatted.charAt(0) == '1';
            case "thai":
                return formatted.charAt(0) == '\u0e51';
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15680().checkResult(formatted, numSystem));
    }
}
