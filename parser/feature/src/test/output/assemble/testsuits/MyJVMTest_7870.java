import java.text.Bidi;

public class MyJVMTest_7870 {

    static String string = "<0@D8XU7bD";

    static boolean directionIsRTL = true;

    boolean testBidi(String string, boolean directionIsRTL) {
        Bidi bidi = new Bidi(string, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        if (bidi.isMixed()) {
            throw new RuntimeException("bidi is mixed");
        }
        if (bidi.isRightToLeft() != directionIsRTL) {
            throw new RuntimeException("bidi is not " + (directionIsRTL ? "rtl" : "ltr"));
        }
        return directionIsRTL;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7870().testBidi(string, directionIsRTL);
    }
}
