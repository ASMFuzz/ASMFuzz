import java.math.*;
import java.text.*;

public class MyJVMTest_7349 {

    static String[] up = { "6", "3", "2", "2", "1", "-1", "-2", "-2", "-3", "-6", "6", "-6", "6", "-6", "2", "-2", "5", "-5", "5", "-5" };

    void basicTest() {
        NumberFormat nf = NumberFormat.getIntegerInstance();
        if (nf.getRoundingMode() != RoundingMode.HALF_EVEN) {
            throw new RuntimeException("default rounding is not HALF_EVEN");
        }
        try {
            nf.setRoundingMode(null);
            throw new RuntimeException("NullPointerException is not thrown by calling setRoundingMode(null)");
        } catch (NullPointerException npe) {
        }
        ChoiceFormat cf = new ChoiceFormat("");
        try {
            cf.setRoundingMode(RoundingMode.HALF_EVEN);
            throw new RuntimeException("UnsupportedOperationException is not thrown by calling setRoundingMode()");
        } catch (UnsupportedOperationException uoe) {
        }
        try {
            cf.getRoundingMode();
            throw new RuntimeException("UnsupportedOperationException is not thrown by calling getRoundingMode()");
        } catch (UnsupportedOperationException uoe) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7349().basicTest();
    }
}
